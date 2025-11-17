public class MoveHyphensInPlace {

    public static void moveHyphens(char[] arr) {
        int j = arr.length - 1;

        // Move non-hyphens to the end, preserving their order
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != '-') {
                arr[j--] = arr[i];
            }
        }

        // Fill the remaining positions at the beginning with '-'
        while (j >= 0) {
            arr[j--] = '-';
        }
    }

    public static void main(String[] args) {
        char[] arr = "a-bc--d-e".toCharArray();
        moveHyphens(arr);
        System.out.println(new String(arr)); // ----abcde
    }
}