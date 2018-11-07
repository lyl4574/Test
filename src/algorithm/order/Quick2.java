package algorithm.order;
//主元放在首位 不知道为什么查询效率很低,
//莫名其妙就好了

public class Quick2 extends SpendTime {
	
	@Override
	void handle(int[] a) {
		quickSort(a,0,a.length-1);
	}

	public void quickSort(int[] a, int begin, int end) {
		if(begin<end){
			int pri = a[begin];
			int j= end+1;
			for(int i=end;i>begin;i--){
				if(a[i]>=pri){
					j--;
					Util.swap(a, i, j);
				}
			}
			j--;
			Util.swap(a,begin,j);
			quickSort(a,j+1,end);
			quickSort(a,begin,j-1);
			
		}
	}
}
