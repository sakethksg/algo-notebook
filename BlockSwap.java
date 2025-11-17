public class BlockSwap{

    /* Function to left rotate arr[] of size n by d */
    static void leftRotate(int arr[], int d, int n){
        int i, j;
        if (d == 0 || d == n)
            return;
        /* If number of rotations is more than array size */
        if (d > n)
            d = d % n;

        i = d;
        j = n - d;

        while (i != j) {
            if (i < j) {
                // A is shorter: swap A with B's first i elements
                swap(arr, d - i, d + j - i, i);
                j -= i;
            }
            else {
                // B is shorter: swap B with A's last j elements
                swap(arr, d - i, d, j);
                i -= j;
            }
        }
        // When A and B are equal, swap them
        swap(arr, d - i, d, i);
    }

    /* Swap subarrays of size d starting at index fi and si */
    static void swap(int arr[], int fi, int si, int d)
    {
        for (int i = 0; i < d; i++) {
            int temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    /* Utility to print array */
    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;

        leftRotate(arr, d, n);
        printArray(arr, n);
    }
}
