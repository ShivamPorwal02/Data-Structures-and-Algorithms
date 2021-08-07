package LoveBabbar.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        PriorityQueue<Integer> pq1;
        PriorityQueue<Integer> pq2;

        public MedianFinder() {
            pq1 = new PriorityQueue<>();
            pq2 = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (pq2.size() == 0 || pq2.peek() > num) pq2.add(num);
            else pq1.add(num);

            if (pq1.size() > pq2.size() + 1) {
                pq2.add(pq1.remove());
            } else if (pq2.size() > pq1.size() + 1) {
                pq1.add(pq2.remove());
            }
        }

        public double findMedian() {
            if (pq1.size() == pq2.size()) {
                return (double) ((double) pq1.peek() + (double) pq2.peek()) / 2.0;
            } else if (pq1.size() > pq2.size()) {
                return (double) pq1.peek();
            } else {
                return (double) pq2.peek();
            }
        }
    }
}
