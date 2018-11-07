package algorithm;

public class Shell2 extends SpendTime{
	@Override
	void handle(int[] a) {
		int n= a.length,flag =1,step=1,i=1;
		while((int)Math.pow(2, i+2)*((int)Math.pow(2, i+2)-3) +1<n){
			step=(int)Math.pow(2, i+2)*((int)Math.pow(2, i+2)-3) +1;
			i++;
		}
		i--;
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
			if(flag==1){
				step=9*((int)Math.pow(4,i))-9*((int)Math.pow(2,i))+1;
				i--;
				flag=0;
			}else{
				step=(int)Math.pow(2, i+2)*((int)Math.pow(2, i+2)-3) +1;
				flag=1;
			}
		}
	}
}
