package org.lld.conceptCoding.designPatterns.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDao employeeDao;
    public EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String clientType, Employee emp) throws Exception {
        if(clientType.equals("ADMIN")){
            employeeDao.create(clientType, emp);
            return;
        }
        throw new Exception("Acces Denied");
    }

    @Override
    public void delete(String clientType, int employeeId) throws Exception {
        if(clientType.equals("ADMIN")){
            employeeDao.delete(clientType, employeeId);
            return;
        }
        throw new Exception("Acces Denied");
    }

    @Override
    public Employee get(String clientType, int employeeId) throws Exception {
        if(clientType.equals("ADMIN") || clientType.equals("USER")){
            return  employeeDao.get(clientType, employeeId);
        }
        throw new Exception("Acces Denied");
    }
}
