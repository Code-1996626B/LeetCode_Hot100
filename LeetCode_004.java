public class LeetCode_004 {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        while (left < nums.length - 1) {
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            if (left == nums.length - 1) {
                break;
            }
            int right = left + 1;
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (right == nums.length) {
                break;
            }
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }
    }
}
