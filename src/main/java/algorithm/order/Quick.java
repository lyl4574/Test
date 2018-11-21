package algorithm.order;

//快速排序是基于分治思想的，把问题的规模递归的变小，然后依次解决子问题，自后得到原问题的解。
/*
 选取最后一位为主元素，把 小于它的放它左面，大于它的放右面。依次 分治。
 */
public class Quick extends SpendTime {
	@Override
	void handle(int[] a) {
		quickSort(a,0,a.length-1);
	}
	private static void quickSort(int[] a,int begin, int end){
		if(begin>=end){
			return;
		}
			System.out.println("quickSort交换前:");
			Util.printArray(a);
		int pri = a[end];
		int j=begin-1;
		for(int i=begin;i<end;i++){
			if(a[i]<=pri){
				j++;
				Util.swap(a,i,j);
			}
		}
		j++;
		Util.swap(a,j,end);
			System.out.println("quickSort交换后:");
		Util.printArray(a);
		quickSort(a,begin,j-1);
		quickSort(a,j+1,end);
	}
	public static void main(String[] args) {
		int [] a={12,1212,2,54,65,745,45,4,999,122,1};
		new Quick().handle(a);
	}
}
