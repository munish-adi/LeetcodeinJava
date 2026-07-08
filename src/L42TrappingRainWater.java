import java.util.Arrays;

public class L42TrappingRainWater {
    public int Brutetrap(int[] height) {
        //for any pos i the lvl of water depends on tallest height on either side = min(leftMax, rightMax) - height[i]
        if(height == null || height.length < 2) {return 0;}
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        for(int i = 0; i< height.length-1; i++) {
            int leftMax = height[left];
            int rightMax = height[right];
            for(int j = 0; j< i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }for(int j = i+1; j< height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax)-height[i];
        }
        return res;
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0){return 0;}
        int maxTrap = 0;
        int left = 0;
        int right = height.length - 1;
        //if left < right : water stoarage depends on left wall and is limited by the left wall hence we only have to move left inwards
        //else move right inwarde
        //we also need to know the highest wall on each side
        //qty of water at each position = max wall on that side - height[i]
        if(height == null || height.length == 0){return 0;}
        int leftMax = height[left];
        int rightMax = height[right];
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                maxTrap += leftMax - height[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                maxTrap += rightMax - height[right];
            }
        }

        return maxTrap;
    }

    public void main(String[] args){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Brutetrap(nums));
    }
}
