public class LongestSequenceOfOnes {

    public static int longestSequenceOfOnes(int binaryNumber) {
        String binaryString = Integer.toBinaryString(binaryNumber);

        int count = 0;
        int maxCount = 0;

        for (char digit : binaryString.toCharArray()) {
            if (digit == '1') {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int binaryNumber = 0b1101110111111001; // Binary representation of 87769
        int longestSequence = longestSequenceOfOnes(binaryNumber);

        System.out.println("The longest sequence of 1's in "
                + Integer.toBinaryString(binaryNumber)
                + " is: " + longestSequence);
    }
}
