package algorithm;
/*1）基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒
。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。*/

/*如果一次循环无交换，退出（高效）flag*/
//最坏情况 最大数在最后
//int [] a={12,1,2,54,65,745,45,4,999,12,1212}; 

//数组长度越大，冒泡算法是最差的
public class Bubble extends SpendTime{
	private static int size = 0;
	@Override
	void handle(int[] a) {
		size = a.length;
//		int count = 0;
		for(int i=0; i<size-1;i++){
//			System.out.println("第"+ (++count) +"次循环开始");
			boolean flag=true;
			for(int j=0; j<size-i-1;j++){
				if(a[j]>a[j+1]){
					Util.swap(a, j, j+1);
					 flag = false;
				}
			}
			if(flag){
				break;
			}
		}
	}
}
