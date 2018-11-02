package ThreadLocalTest;

import lombok.Data;

public class SessionHandlerDemo {
    private static ThreadLocal<Session> session = new ThreadLocal<Session>(){
        @Override
        protected Session initialValue(){
            return new Session();
        }
    };
//    @Data
    public static class Session {
        private String id;
        private String user;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
    public String getUser() {
        return session.get().getUser();
    }
    public String getStatus() {
        return session.get().getStatus();
    }
    public void setStatus(String status) {
        session.get().setStatus(status);
    }
    public static void main(String[] args) {
        new Thread(() -> {
            SessionHandlerDemo handler = new SessionHandlerDemo();
//            handler.createSession();
            handler.getStatus();
            handler.getUser();
            handler.setStatus("close");
            handler.getStatus();
        }).start();
    }
}