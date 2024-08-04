package org.lld.conceptCoding.designPatterns.LoggingSystemChainOfResponsibilty;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(LogLevel logLevel, String message){
        if(logLevel == LogLevel.DEBUG){
            System.out.println("DEBUG");
        }
        else{
            super.log(logLevel,message);
        }
    }
}
