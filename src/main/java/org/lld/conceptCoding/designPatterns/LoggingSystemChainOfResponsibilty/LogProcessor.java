package org.lld.conceptCoding.designPatterns.LoggingSystemChainOfResponsibilty;

public abstract class LogProcessor {
    LogProcessor nextProcessor;
    public LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public void log(LogLevel logLevel, String message){
        if(nextProcessor != null){
            nextProcessor.log(logLevel, message);
        }
    }
}
