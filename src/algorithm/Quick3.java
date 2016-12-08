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
		quickSort(a,begin,i-1);
		quickSort(a,i+1,end);
	}
}
