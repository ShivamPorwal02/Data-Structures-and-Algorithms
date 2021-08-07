import java.util.ArrayList;

public class ArrayListIntro {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list+" -> "+list.size());

        //add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list+" -> "+list.size());

        list.add(1,1000); //1st index pr 1000 daaldega
        System.out.println(list+" -> "+list.size());

        int val = list.get(1); // list[1] se kchni milega
        System.out.println(val);

        // set
        list.set(1,2000);
        System.out.println(list+" -> "+list.size());

        //remove
        list.remove(1);
        System.out.println(list+" -> "+list.size());

        // String Array
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("hello");
        l2.add("bello");
        l2.add("cello");
        System.out.println(l2+"->"+l2.size());

        for (int i=0;i<list.size() ;i++ ) {
            int val1 = list.get(i);
            System.out.println(val1);
        }

        // different tech to print

        for (int val1:list)
        {
            System.out.println(val1);
        }

        System.out.println(list);
        }
}
