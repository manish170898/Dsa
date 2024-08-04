package org.lld.old.designPatterns.AdapterDP;

public class EnemyRobotAdapter implements EnemyAttacker {
    EnemyRobot robot;

    public EnemyRobotAdapter(EnemyRobot robot){
        robot = new EnemyRobot();
    }

    @Override
    public void fireWeapon() {
        robot.smashWithHands();
    }

    @Override
    public void driveForward() {
        robot.walkForward();
    }

    @Override
    public void assignDriver(String driverName) {
        robot.reactTohuman(driverName);
    }
}
