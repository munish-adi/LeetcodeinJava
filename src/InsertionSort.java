import java.util.Arrays;

public class InsertionSort {
    public void insertionsort(int[] nums){
        for (int j = 1; j < nums.length; j++){
            int key = nums[j];
            //insert key in nums[1...j-1] such that it follows sorting order
            int i = j-1;
            while (i>=0 && nums[i]>key){
                nums[i+1] = nums[i];
                i=i-1;
            }
            nums[i+1] = key;
        }
    }

    public void recursivesolution(int[] nums, int n){ //n = nums.length-1
        if (n>1){
            recursivesolution(nums, n-1);
            Insert(nums, n);
        }
    }

    public void Insert(int[] nums, int j){
        int key = nums[j];
        int i = j - 1;
        while(i>=0 && nums[i]>key){
            nums[i + 1]=nums[i];
            i = i - 1;
        }
        nums[i + 1] = key;
    }

    public void main(){
        int[] arr = {5,2,4,6,1,3};
        insertionsort(arr);
        System.out.print("Sorted array : ");
        System.out.print(Arrays.toString(arr));

        System.out.println();

        int[] arr2 = {5,2,4,7,1,3};
        int n = arr.length-1;
        recursivesolution(arr2, n);
        System.out.print("Sorted array : ");
        System.out.print(Arrays.toString(arr2));
    }
}
