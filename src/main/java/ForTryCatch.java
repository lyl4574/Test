public class ForTryCatch {
    public static void main(String[] args) {
        for(int i=100;i>0;i--){
            try{
                if(0 == i%10){
                    System.out.println(5/0);
                }
            }catch (Exception e){
                System.out.println("error:" + i);
//                throw e;

            }
        }
    }

}
