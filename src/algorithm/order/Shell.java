package algorithm.order;

public class Shell extends SpendTime {

	@Override
	void handle(int[] a) {
		int n= a.length;
		int step=n/2;
		for(;step>=1;){
			for(int j=0;j<step;j++){
				for(int k=j+step;k<n;k+=step){
					if(a[k]<a[k-step]){
						int tmp=a[k];
						int m = k-step;
						for(;m>=0 && a[m]>tmp;m-=step){
							a[m+step]=a[m];
						}
						a[m+step]=tmp;
					}
				}
			}
			step=step/2;
		}
	}
}
