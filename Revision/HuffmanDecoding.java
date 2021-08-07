package Revision;

public class HuffmanDecoding {
    public class MinHeapNode
{
    char data;
    int freq;
    MinHeapNode left, right, top;
    MinHeapNode(char c, int freq)
    {
        left = right = null;
        this.data = c;
        this.freq = freq;
    }
}
    static String s = "";
    static String decodeHuffmanData(MinHeapNode root, String str)
    {
        MinHeapNode temp = root;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
            if(temp.left==null && temp.right==null){
                s+=temp.data;
                temp = root;
            }
        }
        return s;
    }
}
