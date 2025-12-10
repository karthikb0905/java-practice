package oop;

public class Inheritance {
    class example{
        example(){
            System.out.println("This is a parent class constructor"); 
        }
    }



    class child extends example{
        child(){
            System.out.println("This is a child class constructor");
        }
    }
}
