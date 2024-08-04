package org.lld.conceptCoding.solid.liskovSubsitution.bad;

//If class B is subtype of class A then we should be able to replace object of A with B without breaking
//behaviour of the program

//Suppose class A has 1 feature then calss B that is extending class A  should have 2 features out of which 1 is from parent so functionality should be expanded
//not narrowed down by extending class
public interface Vehicle {
    void turnOnEngine() throws Exception;
    void acclerate();
}


