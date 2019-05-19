package design.structure.responsibility;

public class ChainPatternDemo {
   
   private static AbstractLogger getChainOfLoggers(){
      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
 
      errorLogger.setNextLogger(consoleLogger);
      consoleLogger.setNextLogger(fileLogger);
 
      return errorLogger;  
   }
 
   public static void main(String[] args) {
      AbstractLogger loggerChain = getChainOfLoggers();
 
      loggerChain.logMessage(AbstractLogger.DEBUG, "This is an information.");
 
//      loggerChain.logMessage(AbstractLogger.DEBUG,
//         "This is a debug level information.");
//
//      loggerChain.logMessage(AbstractLogger.ERROR,
//         "This is an error information.");
   }
}