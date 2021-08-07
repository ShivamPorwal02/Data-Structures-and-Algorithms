package LoveBabbar.StackandQueues;

public class ImplementTwoStacksinArray {
    class TwoStack
    {

        int size;
        int top1,top2;
        int arr[] = new int[100];

        TwoStack()
        {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }

    class Stacks
    {
        //Function to push an integer into the stack1.
        void push1(int x, TwoStack sq)
        {
            sq.top1++;
            if(sq.top1>sq.top2){
                return;
            }
            sq.arr[sq.top1] = x;
        }

        //Function to push an integer into the stack2.
        void push2(int x, TwoStack sq)
        {
            sq.top2--;
            if(sq.top1>sq.top2){
                return;
            }
            sq.arr[sq.top2] = x;
        }

        //Function to remove an element from top of the stack1.
        int pop1(TwoStack sq)
        {
            if(sq.top1==-1) return -1;
            int temp =sq.arr[sq.top1];
            sq.top1--;
            return temp;

        }

        //Function to remove an element from top of the stack2.
        int pop2(TwoStack sq)
        {
            if(sq.top2 == sq.size) return -1;

            int temp =  sq.arr[sq.top2];
            sq.top2++;
            return temp;
        }
    }
}
