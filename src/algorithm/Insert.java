package algorithm;

public class Insert extends SpendTime {

	@Override
	void handle(int[] a) {
//		int point=1;
//		int tmp;
//		for(int j=point-1;point<a.length;j--){
//			if(j==-1 || a[j]<=a[point]){
//				tmp = a[point];
//				for(int k=point;k>j+1;k--){
//					a[k]=a[k-1];
//				}
//				a[j+1]=tmp;
//				++point;
//				j=point;
//			}
//		}
		int n = a.length;
		for(int j=1;j<n;j++){
			if(a[j]<a[j-1]){
				int tmp=a[j];
				int k=j-1;
				for(;k>=0 && a[k]>tmp;k--){
					a[k+1]=a[k];
				}
				a[k+1]= tmp;
			}
		}
	}
}
