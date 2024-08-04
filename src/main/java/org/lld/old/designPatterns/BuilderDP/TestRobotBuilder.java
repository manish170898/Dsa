package org.lld.old.designPatterns.BuilderDP;

public class TestRobotBuilder {
    public static void main(String[] args){
        RobotBuilder builder = new OldRobotBuilder();
        RobotEngineer engineer = new RobotEngineer(builder);

        engineer.makeRobot();
        Robot robot = engineer.getRobot();

        System.out.println(robot.getRobotHead());
    }
}
