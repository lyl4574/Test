package algorithm;
//与桶排序区别，基数排序放进去就排好了序，但需要循环放桶，桶排序 一次性放桶，需要桶内排序。
public class Radix extends SpendTime{

	@Override
	void handle(int[] a) {
		int len = a.length;
		int unit=100;//桶的个数 or 基数(数组大时，桶越大越快，但木有空间)
		int n=1;//代表位数对应的数：
		int [][] tmp = new int[unit][len];
		int[] order = new int[unit];
		boolean flag=true;
		while(flag){
			for(int i=0;i<len;i++){
				int digit=a[i]/(int)Math.pow(unit,n-1)%unit;;
				tmp[digit][order[digit]] = a[i];
				order[digit]++;
			}
			if(order[0]==len){
				flag=false;
				break;
			}
			int m=0;
			for(int j=0;j<unit;j++){
				if(order[j]!=0){
					for(int k=0;k<order[j];k++){
						a[m]=tmp[j][k];
						m++;
					}
				}
				order[j]=0;
			}
//			sort
			n++;
		}
	}
}
