package design.state;
/*状态模式要点
        (1)客户不会和状态进行交互,全盘了解状态是 context的工作
        (2)在状态模式中，每个状态通过持有Context的引用，来实现状态转移
        (3)使用状态模式总是会增加设计中类的数目，这是为了要获得程序可扩展性，弹性的代价，如果你的代码不是一次性的，后期可能会不断加入不同的状态，那么状态模式的设计是绝对值得的。【同时也是一个缺点】
        (4)状态类可以被多个context实例共享
    状态模式和策略模式对比
    一句话：最根本的差异在于策略模式是在求解同一个问题的多种解法，这些不同解法之间毫无关联；状态模式则不同，状态模式要求各个状态之间有所关联，以便实现状态转移。
         一些流行的策略模式的例子是写那些使用算法的代码，例如加密算法、压缩算法、排序算法。客户通常主动指定context所要组合的策略对象是哪一个。
        */
public class StatePatternDemo {
   public static void main(String[] args) {
      Context context = new Context();
 
      StartState startState = new StartState();
      startState.doAction(context);
 
      System.out.println(context.getState().toString());
 
      StopState stopState = new StopState();
      stopState.doAction(context);
 
      System.out.println(context.getState().toString());
   }
}