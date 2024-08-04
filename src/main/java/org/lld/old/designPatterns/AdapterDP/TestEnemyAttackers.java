package org.lld.old.designPatterns.AdapterDP;

public class TestEnemyAttackers {
    EnemyTank tank = new EnemyTank();

    EnemyRobot robot = new EnemyRobot();

    EnemyAttacker robotadapter = new EnemyRobotAdapter(robot);
}
