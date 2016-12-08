package algorithm;
//选择排序，每次选择最小的，每次循环只需交换一次
public class Choose extends SpendTime{
	private static int size = 0;
	@Override
	void handle(int[] a) {
		size = a.length;
//		int count = 0;
		for(int i=0;i<size-1;i++){
//			System.out.println("第"+ (++count) +"次循环开始");
			int min = i;
			for(int j=i+1;j<size;j++){
				if(a[min]>a[j]){
					min=j;
				}
			}
			Util.swap(a, i, min);
		}
	}
}
