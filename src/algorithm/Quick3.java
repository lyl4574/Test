package algorithm;

public class Quick3 extends SpendTime{

	@Override
	void handle(int[] a) {
		quickSort(a,0,a.length-1);
	}

	private void quickSort(int[] a, int begin, int end) {
		if(begin>=end){
			return;
		}
		int pri = a[begin];
		int i = begin;
		int j= end;
		do{
			for(;j>i;j--){
				if(a[j]<pri){
					a[i]=a[j];
					break;
				}
			}
			for(;i<j;i++){
				if(a[i]>pri){
					a[j]=a[i];
					break;
				}
			}
		}while(i!=j);
		a[i]=pri;
		Util.printArray(a);
		quickSort(a,begin,i-1);
		quickSort(a,i+1,end);
	}
	public static void main(String[] args) {
		int [] a={12,1212,2,54,65,745,45,4,999,122,1};
		new Quick3().handle(a);
	}
}
