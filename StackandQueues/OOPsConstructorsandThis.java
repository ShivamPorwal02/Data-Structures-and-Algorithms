package StackandQueues;

public class OOPsConstructorsandThis {
    public static class Person{
        int age;
        String name;
        void saysHi(){
            System.out.println(name+"["+age+"] says hi");
        }

        // if we dont write constructor java automatically provides the default constructor
        // but we write any type of constructor parametrized or non paametirzed then java wont provide default constructor

        Person(){
            // our constructor
        }
        Person(int age,String name){
            this.age = age;  // left hand wala age upr wale age k lia hai jbki right wala parameter wala hai
            this.name = name;
        }
    }
    public static void main(String[] arr){
        Person p1 = new Person();
        p1.saysHi();
        Person p2 = new Person(10,"a");
        p2.saysHi();
    }

}
