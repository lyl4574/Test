package algorithm.order;

public class Bucket extends SpendTime {

	@Override
	void handle(int[] a) {
		int len =  a.length;
		int unit=10;//桶内数大小范围单位
		int num = len*10/unit;//桶数量
		int tmp[][] = new int[num][1000];//桶容量
		int order[] = new int[len*10];//单个桶内排序
		int m=0;//具体 数组项放在的桶编号
		for(int i=0;i<len;i++){
			m=a[i]/unit;
			tmp[m][order[m]]=a[i];
			//桶内排序
			int k= order[m]++;
			if(k>0){
				if(a[i]<tmp[m][k-1]){
					int h=k-1;
					for(;h>=0 && tmp[m][h]>a[i];h--){
						tmp[m][h+1]=tmp[m][h];
					}
					tmp[m][h+1]=a[i];
				}
			}
		}
		int n=0;
		for(int j=0;j<num;j++){
			for(int k=0;k<order[j];k++){
				a[n++]=tmp[j][k];
			}
		}
	}
}
