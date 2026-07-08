import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class L11ContainerWithMostWater {
    public int maxArea(int[] height){

        int maxArea = 0;
            int left = 0;
            int right = height.length - 1;
            while(left < right){
                int length = right-left;
                int breadth = Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, length*breadth);
                if(height[left] < height[right]){
                    left++;
                }
                else right--;
            }

        return maxArea;
    }

    public void main(String[] args){
        int[] nums = new int[]{8,7,2,1};
        System.out.println(maxArea(nums));

    }
}

//#be proud nigga
