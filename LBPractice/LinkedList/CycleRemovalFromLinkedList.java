package LoveBabbar.LinkedList;

public class CycleRemovalFromLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static void removeLoop(Node head) {

        if (head == null || head.next == null)
            return;
        Node slow = head, fast = head, prev = null;

        // issm prev ka role imp hai hme lek chlna pdega niche jaak define ni krr skte ussse problems hoti hai ki agr loop m ni gya to aese aese islia phle se hi hme prv ko lek chkna pdega


        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Node prev = slow;
        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            prev.next = null;
        }
    }
}

// achi baat ni hai but still i will manage to do it in some style i m wasting my time as well
