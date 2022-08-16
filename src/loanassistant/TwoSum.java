package loanassistant;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int indices[] = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i == j && (nums[i] + nums[j] != target)) {
                    continue;
                }
                else if ((nums[i] + nums[j] == target) && (i != j)) {
                    int lowestVal, highestVal;
                    lowestVal = (i > j)? j : i;
                    highestVal = (i > j)? i : j;
                    indices[0] = lowestVal;
                    indices[1] = highestVal;
                    break;
                }
            }
        }
        return indices;
    }
}
