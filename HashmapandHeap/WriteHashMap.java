package HashmapandHeap;

import java.util.ArrayList;
import java.util.LinkedList;

public class WriteHashMap {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        public void rehash() throws Exception{
            LinkedList<HMNode>[] oda = buckets;

            initbuckets(2*oda.length);
            size = 0;
            for(int i=0;i<oda.length;i++){
                for(HMNode node:oda[i]){
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key, V value) throws Exception {
            int bi = hashfn(key); // bucket index
            int di = getIndexWithinBucket(key,bi);  //data index

            if(di!=-1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                HMNode node = new HMNode(key,value);
                buckets[bi].add(node);
                size++;
            }
            double lambda = (size*1.0)/buckets.length;
            if(lambda>2.0){
                rehash();
            }

        }
        public int hashfn(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%buckets.length;
        }

        public int getIndexWithinBucket(K key,int bi){
            int di = 0;
            for(HMNode node:buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }
        public V get(K key) throws Exception {
            int bi = hashfn(key); // bucket index
            int di = getIndexWithinBucket(key,bi);  //data index

            if(di!=-1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }


        public boolean containsKey(K key) {
            int bi = hashfn(key); // bucket index
            int di = getIndexWithinBucket(key,bi);  //data index

            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }

        public V remove(K key) throws Exception {
            int bi = hashfn(key); // bucket index
            int di = getIndexWithinBucket(key,bi);  //data index

            if(di!=-1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keyset() throws Exception {
            ArrayList<K> k = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                for(HMNode node : buckets[i]){
                    k.add(node.key);
                }
            }
            return k;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print( node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }
}
