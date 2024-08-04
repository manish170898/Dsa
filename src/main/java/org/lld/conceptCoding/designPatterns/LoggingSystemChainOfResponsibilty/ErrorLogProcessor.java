package org.lld.conceptCoding.designPatterns.LoggingSystemChainOfResponsibilty;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(LogLevel logLevel, String message){
        if(logLevel == LogLevel.ERROR){
            System.out.println("ERROR");
        }
        else{
            super.log(logLevel,message);
        }
    }
}
