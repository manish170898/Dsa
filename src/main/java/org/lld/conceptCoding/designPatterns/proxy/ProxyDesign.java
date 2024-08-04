package org.lld.conceptCoding.designPatterns.proxy;

public class ProxyDesign {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDaoProxy();
        try{
            dao.create("ADMIN", new Employee());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
