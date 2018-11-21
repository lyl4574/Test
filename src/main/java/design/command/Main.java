package design.command;
/*
 命令模式 将"行为请求者"与"行为实现者"解耦
 */
public class Main {
    public static void main(String[] args) {
        //行为实现者
        Tv tv = new Tv();
        //行为请求者
        RemoteController remoteController =  new RemoteController();

        remoteController.execute(new OpenCommand(tv));
        remoteController.execute(new OffCommand(tv));
    }
}
