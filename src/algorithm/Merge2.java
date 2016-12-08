package algorithm;

public class Merge2 extends SpendTime {

	@Override
	void handle(int[] a) {
		int[] tmp = new int[a.length];
		mergeSort(a,0,a.length-1,tmp);
	}
	void mergeSort(int a[], int first, int last, int temp[])  
	{  
	    if (first < last)  
	    {  
	        int mid = (first + last) / 2;  
	        mergeSort(a, first, mid, temp);    //左边有序  
	        mergeSort(a, mid + 1, last, temp); //右边有序  
	        mergeArray(a, first, mid, last, temp); //再将二个有序数列合并  
	    }  
	}  
	void mergeArray(int a[], int first, int mid, int last, int temp[])  
	{  
	    int i = first, j = mid + 1;  
	    int m = mid,   n = last;  
	    int k = 0;  
	      
	    while (i <= m && j <= n)  
	    {  
	        if (a[i] <= a[j])  
	            temp[k++] = a[i++];  
	        else  
	            temp[k++] = a[j++];  
	    }  
	      
	    while (i <= m)  
	        temp[k++] = a[i++];  
	      
	    while (j <= n)  
	        temp[k++] = a[j++];  
	      
	    for (i = 0; i < k; i++)  
	        a[first + i] = temp[i];  
	} 
}
