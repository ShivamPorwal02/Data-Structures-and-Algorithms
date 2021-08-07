package LoveBabbar.LinkedList;

public class isLinkedListPallindrome {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public boolean isPalindrome(ListNode head) {

        //  O(n) time and O(1) space
        if(head.next==null){
            return true;
        }

        // middle of linked list

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null &&  fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse of a half part of linked list aage walaa

        slow.next = reverse(slow.next);

        slow = slow.next;
        ListNode newslow = head;

        while(slow!=null){
            if(slow.val!=newslow.val){
                return false;
            }
            slow = slow.next;
            newslow = newslow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode nex = null;
        while(head!=null){
            ListNode nexhead = head.next;
            head.next = prev;
            prev = head;
            head = nexhead;
        }
        return prev;
    }
    public static boolean isPallindrome_method2(ListNode head) {
            if (head.next == null) {
                return true;
            }
            int cnt = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                cnt++;
            }
            int[] arr = new int[cnt];

            temp = head;
            int k = 0;
            while (temp != null) {
                arr[k] = temp.val;
                temp = temp.next;
                k++;
            }
            return isPallindrome(arr);
        }
        public static boolean isPallindrome(int[] arr){
            int i = 0;
            int j = arr.length-1;

            while(i<=j){
                if(arr[i]!=arr[j]){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
