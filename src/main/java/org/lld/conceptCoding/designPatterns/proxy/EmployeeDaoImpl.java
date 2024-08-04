package org.lld.conceptCoding.designPatterns.proxy;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void create(String clientType, Employee emp) {
        System.out.println("Created a new row with object");
    }

    @Override
    public void delete(String clientType, int employeeId) {
        System.out.println("depeted the employe with id: " + employeeId);
    }

    @Override
    public Employee get(String clientType, int employeeId) {
        System.out.println("Found Employeee");
        return new Employee();
    }
}
