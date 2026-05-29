public class CountingSort {
    public static int arraymax(int[] arr){
        int mx = arr[0];
        for (int i = 1; i<arr.length; i++){
            if (arr[i]>mx){
                mx = arr[i];
            }
        }
        return mx;
    }

    public static void countingsort(int[] A, int[] B){
        int k = arraymax(A);

        int[] C = new int[k+1]; //making C in java they're already set to 0

        for (int j : A) {
            C[j]++;
        }

        for(int i = 1; i<k; i++){
            C[i] = C[i] + C[i-1];
        }

        for (int i = A.length-1; i >= 0; i--){
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }

    }

    public static void main(){
        int[] A = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = new int[A.length];

        countingsort(A, B);

        System.out.print("Original: ");
        for (int x : A) {
            System.out.print(x + " ");
        }

        System.out.print("\nSorted: ");
        for (int x : B) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
