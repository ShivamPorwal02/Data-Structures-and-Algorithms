package StackandQueues;

public class OOPS_ClassesandObjects {
    public static class Person{
        int age;
        String name;
        void saysHI(){
            System.out.println(name +"["+age+"] says hi");
        }
    }
    public static void main(String[] arr){
        Person p1 = new Person();
        p1.age=10;
        p1.name = "A";
        p1.saysHI();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.saysHI();

        Person p3 = p1;
        p3.age = 30;
        p3.saysHI();
        p1.saysHI();

    }
}
