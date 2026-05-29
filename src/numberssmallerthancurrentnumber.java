public class numberssmallerthancurrentnumber {
    public static void smallernumber(int[] nums){
        int max = CountingSort.arraymax(nums);
        int[] count = new int[max+1];
        int[] missingcount = new int[nums.length];

        for(int j : nums){
            count[j]++;
        }

        System.out.print("Count with 0's:");
        for(int i : count){
            System.out.print(i + " ");
        }

        for (int i = 1; i <= max; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println(" ");
        System.out.print("Prefix Sums:");
        for(int i : count){
            System.out.print(i + " ");
        }

        //now replace elements of nums with their values in the hashmap
        for(int i = 0; i<nums.length; i++){
            int currentNumber = nums[i];

            // Instead of a HashMap, just use the count array index!
            // If currentNumber is 8, count[8] gives you the end sum value.
            missingcount[i] = count[currentNumber-1];
        }

        System.out.println(" ");
        System.out.print("Final array :");
        for(int i : missingcount){
            System.out.print(i + " ");
        }


    }

    public static void main(){
        int[] nums = {8,1,2,2,3};
        smallernumber(nums);
    }


}
