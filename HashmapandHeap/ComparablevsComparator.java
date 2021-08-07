package HashmapandHeap;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparablevsComparator {
    public static class PriorityQueue <T> {
        ArrayList<T> data;
        Comparator comp = null;

        public PriorityQueue() {
            data = new ArrayList<>();
            comp = null;
        }
        public PriorityQueue(Comparator comp){
            data = new ArrayList<>();
            this.comp = comp;
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size()-1);
        }
        private void upheapify(int i){
            if(i==0){
                return;
            }
            int pi = (i-1)/2;
            if(isSmaller(i,pi)==true){
                swap(i,pi);
                upheapify(pi);
            }
        }
        private boolean isSmaller(int i,int j){
            if(comp==null) {
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                if (ith.compareTo(jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            }else{
                T ith = data.get(i);
                T jth = data.get(j);
                if (comp.compare(ith,jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        private void swap(int i,int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i,jth);
            data.set(j,ith);
        }

        public T remove() {
            if(this.size()==0){
                System.out.println("Underflow");
                return null;
            }
            swap(0,data.size()-1);
            T val = data.remove(data.size()-1);
            downheapify(0);
            return val;
        }
        private void downheapify(int pi){
            int mini = pi;
            int li = 2*pi+1;
            if(li<data.size() && isSmaller(li,mini)==true){
                mini = li;
            }
            int ri = 2*pi+2;
            if(ri<data.size() && isSmaller(ri,mini)==true){
                mini = ri;
            }
            if(mini!=pi){
                swap(pi,mini);
                downheapify(mini);
            }

        }

        public T peek() {
            if(this.size()==0){
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }
    public static class Student implements Comparable<Student>{
        int roll;
        int ht;
        int wt;
        Student(int roll,int ht,int wt){
            this.roll=roll;
            this.ht = ht;
            this.wt = wt;
        }
        public int compareTo(Student o){
            return this.roll-o.roll;
        }
        public String toString(){
            return "Rno = "+this.roll+"wt = "+this.ht+"wt = "+this.wt;
        }
    }
    public static class studentHTcomparator implements Comparator<Student> {
        public int compare(Student s1,Student s2){
            return s1.ht-s2.ht;
        }
    }
    public static class studentWTcomparator implements Comparator<Student> {
        public int compare(Student s1,Student s2){
            return s1.wt-s2.wt;
        }
    }
    public static void main(String[] arr) throws Exception{
        PriorityQueue<Student> pq = new PriorityQueue<>(new studentHTcomparator());

        pq.add(new Student(1,160,50));
        pq.add(new Student(2,170,60));
        pq.add(new Student(3,185,70));
        pq.add(new Student(4,165,80));
        pq.add(new Student(5,190,90));

        while (pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }

}
