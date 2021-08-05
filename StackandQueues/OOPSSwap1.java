package StackandQueues;

public class OOPSSwap1 {
    public static class Person{
        int age;
        String name;
        void saysHI(){
            System.out.println(name+"["+age+"] says hi");
        }
    }
    public static void main(String[] arr){
        Person p1 = new Person();
        p1.age=10;
        p1.name = "A";
//        p1.saysHI();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
//        p2.saysHI();

        p1.saysHI();
        p2.saysHI();
        swap(p1,p2);
        p1.saysHI();
        p2.saysHI();
    }
    public static void swap(Person p1,Person p2){
        Person temp = p1;
        p1=p2;
        p2=temp;
    }
}
