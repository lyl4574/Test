package algorithm;

public abstract class SpendTime {
 public void exe(int[] a){
	 Long beginTime = System.currentTimeMillis();
	 System.out.println(this.getClass().getName() + "开始执行时间："+beginTime);
	 int size = a.length;
//	 System.out.print("初始队列：");
//	 for(int k=0;k<size; k++){
//		System.out.print(a[k]+",");
//	 } 
//	 System.out.println();
	 handle(a);
	 System.out.print("最终队列：");
	 for(int k=0;k<size; k++){
		System.out.print(a[k]+",");
	 }
	 System.out.println();
	 System.out.println(this.getClass().getName()+"spend时间："+ (System.currentTimeMillis()-beginTime));
 }

	abstract void handle(int[] a);

}
