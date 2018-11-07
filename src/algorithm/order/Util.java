package algorithm.order;

public class Util {
	public static void swap(int[] a,int i, int j){
		if(i==j){
			return;
		}
		int tmp;
		tmp = a[i];
		a[i]=a[j];
		a[j]=tmp;
//		System.out.println("swap交换后"+i);
//		printArray(a);
	}
	
	public static void printArray(int[] a){
		int length = a.length;
		for(int k=0;k<length; k++){
			System.out.print(a[k]+",");
		}
		System.out.println();
	}
	//获取数据 的 某位数
	public static int getDigit(int data,int digit){
		if(digit<=0||data==0){
			return 0;
		}
		return data/(int)Math.pow(1000,digit-1)%1000;
	}
	
	//求总位数
	public static int getNumOfDigits(int a)
	{
	    int count=0;
	    while(a!=0)
	    {
	        a/=10;
	        count++;
	    }
	    return count;
	}
}
