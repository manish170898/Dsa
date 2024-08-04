package org.lld.conceptCoding.designPatterns.LoggingSystemChainOfResponsibilty;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogLevel.INFO, "Message");
    }
}
