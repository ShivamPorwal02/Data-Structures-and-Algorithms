package LoveBabbar.SortingAndSearching;

public class OptimumLocationofpointtoMinimizeTotalDistance {
    static int EPS = (int)(1e-6) + 1;
    static int N = 5;
    static class point{
        int x;
        int y;
        point(int x,int y){
            this.x=x;
            this.y = y;
        }
    }
    static class line{
        int a;
        int b;
        int c;
        line(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static double dist(double x,double y,point p){
        return Math.sqrt(Math.pow((x-p.x),2)+Math.pow((y-p.y),2));
    }
    static double compute(point[] p,int n,line l,double x){
        double res = 0;
        double y = -1*(l.c+l.a*x)/l.b;
        for (int i=0;i<n ;i++ ) {
            res+=dist(x,y,p[i]);
        }
        return res;
    }
    static double findOptimumCostUtil(point p[], int n,
                                      line l)
    {
        double low = -1e6;
        double high = 1e6;

        // loop untill difference between low and high
        // become less than EPS
        while ((high - low) > EPS) {
            // mid1 and mid2 are representative x
            // co-ordiantes of search space
            double mid1 = low + (high - low) / 3;
            double mid2 = high - (high - low) / 3;

            double dist1 = compute(p, n, l, mid1);
            double dist2 = compute(p, n, l, mid2);

            // if mid2 point gives more total distance,
            // skip third part
            if (dist1 < dist2)
                high = mid2;

                // if mid1 point gives more total distance,
                // skip first part
            else
                low = mid1;
        }

        // compute optimum distance cost by sending average
        // of low and high as X
        return compute(p, n, l, (low + high) / 2);
    }

    // method to find optimum cost
    static double findOptimumCost(int points[][], line l)
    {
        point[] p = new point[N];

        // converting 2D array input to point array
        for (int i = 0; i < N; i++)
            p[i] = new point(points[i][0], points[i][1]);

        return findOptimumCostUtil(p, N, l);
    }
    public static void main(String[] args)
    {
        line l = new line(1, -1, -3);
        int points[][] = { { -3, -2 },
                { -1, 0 },
                { -1, 2 },
                { 1, 2 },
                { 3, 4 } };
        System.out.println(findOptimumCost(points, l));
    }
}
