public class MajorityElement {

    public static int findMajorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // Verify the candidate
        int majorityCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                majorityCount++;
            }
        }

        if (majorityCount > nums.length / 2) {
            return candidate;
        }

        return -1; // No majority element
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};

        int result = findMajorityElement(nums);

        if (result != -1) {
            System.out.println("Majority element: " + result);
        } else {
            System.out.println("No majority element found.");
        }
    }
}
