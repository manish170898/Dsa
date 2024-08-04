package org.lld.old.solid.OpenClosed;


//PROBLEM

//public class Operation {
//    public double calculate(double a1, double a2, String operationType){
//
//        switch (operationType){
//            case "+": {          //Add Operation
//                return a1+a2;
//            }
//            case "-": {          // Subtract Operation
//                return a1-a2;
//            }
//            default:{
//
//            }
//            //There might be many cases and while modifying the previous codde we might add in new bugs.
//        }
//        return 0;
//    }
//}


//SOLUTION
// This way we can add new functionality without modifying precvious finctionalities
public interface Operation{
    public double calculate(double a1, double a2);
}

class AddOperation implements Operation{
    @Override
    public double calculate(double a1, double a2) {
        return a1+a2;
    }
}

class DivisionOperation implements  Operation{
    @Override
    public double calculate(double a1, double a2) {
        return a1/a2;
    }
}
