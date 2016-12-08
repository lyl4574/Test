package algorithm;
//
/*
 * 基数排序没有足够多的空间，只有再10000大小的数组内 比较快。
 * 100以内，选择冒泡和插入比较好，稳定。
 * 1亿
 * quick 12000
 * shell 50000
 * merge 2000~25000
 * bucket 28000
 * 统计1000w 时间  
 * shell 4000~
 * quick 1100~1200
 * merge 1800~1850
 * bucket 2000~ 桶排序随着桶数量增加，分配空间很耗时，理论上是比快速排序快，实际上没快速排序快。
 * 花费时间主要在桶初始化空间，
 * 统计100w 时间  
 * shell 270~300
 * quick 110~130
 * merge 170~200
 * 
 * 统计10w时间
 * bubble 15000
 * choose 4300
 * insert 1250
 * */
public class Client {
	public static void main(String[] args) {
		int[] a = new int[10];  
        for (int k = 0; k < a.length; k++) {  
        	a[k] = (int) (Math.random() * 100);  
        }
//		 new Choose().exe(a);
//        new Bubble().exe(a);
//        new Quick().exe(a);
//        new Quick2().exe(a);
//        new Quick3().exe(a);
//        new Insert().exe(a);
        new Merge().exe(a);
//        new Merge2().exe(a);
//          new Shell().exe(a);
//        new Shell2().exe(a);
//      new Radix().exe(a);
//        new Bucket().exe(a);
	}
}
