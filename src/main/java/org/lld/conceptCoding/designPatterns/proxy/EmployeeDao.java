package org.lld.conceptCoding.designPatterns.proxy;

public interface EmployeeDao {
    public void create(String clientType, Employee emp) throws Exception;
    public void delete(String clientType, int employeeId) throws Exception;
    public Employee get(String clientType, int employeeId) throws Exception;
}
