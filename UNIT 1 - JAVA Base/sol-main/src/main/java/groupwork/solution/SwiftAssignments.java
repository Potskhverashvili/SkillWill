package groupwork.solution;

import java.util.ArrayList;
import java.util.List;

public class SwiftAssignments {
    public static void main(String[] args) {

        int [] nums = {3,3,4,5,6,5,6};

        System.out.println(singleNumber(nums));


    }

    static public int singleNumber(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] != nums[i]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
