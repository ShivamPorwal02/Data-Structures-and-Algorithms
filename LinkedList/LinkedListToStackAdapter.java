package LinkedList;

import java.util.LinkedList;

public class LinkedListToStackAdapter {
    public static class LLToStackAdapter{
        LinkedList<Integer> list;
        public LLToStackAdapter(){
            list = new LinkedList<>();
        }
        int size(){
           return list.size();
        }
        void push(int val){
            list.addFirst(val);
        }
        int pop(){
            return list.removeFirst();
        }
        int top(){
            return list.getFirst();
        }
    }
    // hm isko chahte to same kaaam last wale se bhi krr skte the but since hmne jo getLast likha tha
    // vo o(1) ni hai islia hmne usse ni kia
    // but jo java m implemented hai vo o(1) m hi hai islia frk ni pdta
}
