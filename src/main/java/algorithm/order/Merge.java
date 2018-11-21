package algorithm.order;

//先将数组不断细分成最小的单位，然后每个单位分别排序，排序完毕后合并，
//重复以上过程最后就可以得到排序结果。
//随着数组增大，归并算法 比快速排序慢，原因，虽归并算法中排序 比较次数少，但合并操作复杂，浪费时间多。
public class Merge extends SpendTime {

	@Override
	void handle(int[] a) {
		mergeSort(a,0,a.length-1);
	}

	private void mergeSort(int[] a,int first,int last) {
		if(first<last){
			int middle = (first+last)/2;
			mergeSort(a,first,middle);
			mergeSort(a,middle+1,last);
			merge(a,first,middle+1,last);
		}
		
	}
	private static void merge(int[] a, int first, int middle, int last) {
		if(first<last){
			int i=first;
			int j=middle;
			int[] c = new int[last-first+1];
			int alen= middle;
			int blen= last+1;
			int k=0;
			while(i<=alen || j<=blen){
				if(i==alen&&j==blen){
					break;
				}
				if(i==alen&&j<blen){
					c[k++]=a[j++];
					continue;
				}
				if(j==blen&&i<alen){
					c[k++]=a[i++];
					continue;
				}
				if(a[i]>a[j]&&j<blen){
					c[k++]=a[j++];
					continue;
				}
				if(a[i]<a[j]&&i<alen){
					c[k++]=a[i++];
					continue;
				}
				if(a[i]==a[j]&&i<alen&&j<blen){
					c[k++]=a[i++];
					c[k++]=a[j++];
					continue;
				}
			}
			for(int m=0;m<c.length;m++){
				a[first+m]=c[m];
			}
		}
	}

	//使用了插入算法排序两个有序数组，a[first,middle-1], a[middle,last],性能差。
	public  static void  mergeInsert(int[]a,int first ,int middle, int last){
		
		if(first==last){
			return;
		}
		int tmp;
		int point = middle;
		for(int i=middle-1;point<=last;i--){
			if(i==first-1|| a[point]>a[i]){
				tmp = a[point];
				for(int k=point;k>i+1;k--){
					a[k]=a[k-1];
				}
				a[i+1]=tmp;
				point++;
				i=point;
			}
		}
		
	}
	public static void main(String[] args) {
		int[]a={2,4,6,7,7,8 ,1,2,3,4,5,6};
		 merge(a,0,6,11);
		Util.printArray(a);
	}
}
