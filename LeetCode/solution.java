package LeetCode;

//import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution {
    static int cnt = 0;
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("abc");
        list.add(100);
        System.out.println(list.get(0) instanceof Object);

        System.out.println(list.get(1) instanceof Integer);
    }
}
