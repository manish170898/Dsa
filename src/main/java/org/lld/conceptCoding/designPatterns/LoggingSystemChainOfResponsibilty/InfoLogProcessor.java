package org.lld.conceptCoding.designPatterns.LoggingSystemChainOfResponsibilty;

public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(LogLevel logLevel, String message){
        if(logLevel == LogLevel.INFO){
            System.out.println("INFO");
        }
        else{
            super.log(logLevel,message);
        }
    }
}
