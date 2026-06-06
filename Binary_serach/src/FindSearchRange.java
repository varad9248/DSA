public class FindSearchRange {

    /*
        Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
        If target is not found in the array, return [-1, -1].
        You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
        Example 2:

        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]
        Example 3:

        Input: nums = [], target = 0
        Output: [-1,-1]

        solution : 
        We need to find 1 ocurrence using the binary search.
        then the last occurence using the binary search.

    */

    public int[] searchRange(int[] nums, int target) {

        int ans[] = { -1 , -1};

        if(nums.length < 1) return ans; 


        int left = binarySerach(nums , target , true);
        int right = binarySerach(nums ,target , false);

        ans[0] = left;
        ans[1] = right;

        return ans;

    }

    public int binarySerach(int nums[] , int target , boolean rightSearch){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) high = mid - 1;
            else if(target > nums[mid]) low =  mid  + 1;
            else {
                // element is found
                // save the mid becuase we found elements occurnace
                ans = mid;
                // deep in right
                if(rightSearch) high = mid - 1;
                // deep in left
                else low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int nums[] = {5 ,7,7,7,7,8,9,10,12,13 ,14};

        FindSearchRange fs = new FindSearchRange();

        int ans[] = fs.searchRange(nums, 7);
        System.out.println(ans[0] + " " + ans[1]);

    }


}
