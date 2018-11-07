package algorithm;
/*
 * 排序稳定性：假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，
 * 即在原序列中，r[i]=r[j]，且r[i]在r[j]之前，而在排序后的序列中，r[i]仍在r[j]之前，则称这种排序算法是稳定的；否则称为不稳定的。
 * 堆排序、快速排序、希尔排序、直接选择排序不是稳定的排序算法，而基数排序、冒泡排序、直接插入排序、折半插入排序、归并排序是稳定的排序算法。（跨位交换 都不稳定，相邻交换稳定）
 *
 *
 * 复杂度：      平均时间  最好时间 	最坏时间
 * 桶排序(不稳定)	O(n)	O(n)	O(n)
 * 基数排序(稳定)	O(n)	O(n)	O(n)
 * 归并排序(稳定)	O(nlogn)	O(nlogn)	O(nlogn)
 * 快速排序(不稳定)	O(nlogn)	O(nlogn)	O(n^2)
 * 堆排序(不稳定)	O(nlogn)	O(nlogn)	O(nlogn)
 * 希尔排序(不稳定)	O(n^1.25)	 	 
 * 冒泡排序(稳定)	O(n^2)	O(n)	O(n^2)
 * 选择排序(不稳定)	O(n^2)	O(n^2)	O(n^2)
 * 直接插入排序(稳定)	O(n^2)	O(n)	O(n^2)
 *
 * O(n)这样的标志叫做渐近时间复杂度,是个近似值.各种渐近时间复杂度由小到大的顺序如下
 * O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)
---------------------
 * 基数排序没有足够多的空间，只有再10000大小的数组内 比较快。
 * bucket 2000~ 桶排序随着桶数量增加，分配空间很耗时，理论上是比快速排序快，实际上没快速排序快。
 * 花费时间主要在桶初始化空间，
 * */
public class Client {
	public static void main(String[] args) {
		int[] a = new int[100];
        for (int k = 0; k < a.length; k++) {  
        	a[k] = (int) (Math.random() * 100);
        }
//		 new Choose().exe(a);
        new Bubble().exe(a);
//        new Quick().exe(a);
//        new Quick2().exe(a);
//        new Quick3().exe(a);
//        new Insert().exe(a);
//        new Merge().exe(a);
//        new Merge2().exe(a);
//          new Shell().exe(a);
//        new Shell2().exe(a);
//      new Radix().exe(a);
//        new Bucket().exe(a);
	}
}
