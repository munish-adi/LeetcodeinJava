public class mintimevisitingallpoints {

    public static int mintimetivisitpoints(int[][] points){
        int min_time_dist = 0;
        for (int i = 1; i < points.length; ++i) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            min_time_dist += Math.max(dx, dy);
        }
        return min_time_dist;

    }

    public static void main(){
        int[][] points = {{1,1}, {3,4}, {-1,0}};
        System.out.print(mintimetivisitpoints(points));
    }
}

