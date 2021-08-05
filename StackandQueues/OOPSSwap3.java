package StackandQueues;

public class OOPSSwap3 {
    public static class Person{
        int age;
        String name;
        void saysHi(){
            System.out.println(name+"["+age+"] says hi");
        }
    }
    public static void swap(Person p1,Person p2){
        p1=new Person();
        int age = p1.age;
        p1.age=p2.age;
        p2.age=age;

        p2= new Person();
        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;

    }

    public static void main(String[] a){
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";

        p1.saysHi();
        p2.saysHi();
        swap(p1,p2);
        p1.saysHi();
        p2.saysHi();
    }
}
