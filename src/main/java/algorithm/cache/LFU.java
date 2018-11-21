package algorithm.cache;
/*
  2. LFU(Least Frequently Used ),最不经常使用，总是淘汰访问频率最小的元素。
       这种算法也存在明显的问题:  a. 如果频率时间度量是1小时，则平均一天每个小时内的访问频率1000的热点数据可能会被2个小时的一段时间内的访问频率是1001的数据剔除掉；
       b. 最近新加入的数据总会易于被剔除掉，由于其起始的频率值低。
       本质上其“重要性”指标访问频率是指在多长的时间维度进行衡量？
       其难以标定，所以在业界很少单一直接使用。也由于两种算法的各自特点及缺点，所以通常在生产线上会根据业务场景联合LRU与LFU一起使用，称之为LRFU。
 */
public class LFU {
}