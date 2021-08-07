package LoveBabbar.Graph;

public class TravellingSalesmaProblem {
    public int total_cost(int[][] graph)
    {
        // Code here
        String a="";
        int n = graph.length;
        for(int i=1;i<n;i++)
        {
            a=a+Integer.toString(i);
        }
// 		string islia bnaya hai ki kitne nodes hai vo pta rha
//  jo "b" hai mtlb hm kaha se jaare hai
// DYNAMIC PROGRAMMING se kia hai

        int min=travelling(graph,a,0,Integer.MAX_VALUE);

        return min;
    }
    // static int  =
    int travelling(int [][]graph,String a,int b,int min)
    {
        if(a.length()==0)
            return graph[b][0];
        for(int i=0;i<a.length();i++)
        {
            min=Math.min(min,(graph[b][a.charAt(i)-'0']+travelling(graph,a.substring(0,i)+a.substring(i+1,a.length()),a.charAt(i)-'0',min)));
        }
        return min;
    }
}
