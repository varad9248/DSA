
public class Flooring_number {

    /*
    
        This problem is about finding the Number is largest but less than or equal to the target in array.

        suppose you have array : {2,3,5,6,8,14,16,18}
        target is 15 then,

            if 15 is present then we return its index.
            if not then,

                we need to check the number which are greater than the target 15
                which are  {2 ,3, 5, 6,8,14}
                and we return the smallest number is this new array.
                so the answer will be 16 or the index 6
        
        In this problem we are searching the sorted array so best algorithm to use in this situation is 'binary search'

        by using the binary search we can eliminate our first condition of : 
            1. if element is present then return the index of it.
            2. if number is not present then we should return the end pointer index.

    */

    
    public int solution (int nums[] , int target){
        
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start < end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else  end = mid -1;
        }

        return end;

    }

    public static void main(String[] args) {
        
        int nums[] = {2,3,5,6,8,14,16,18};

        Flooring_number f = new Flooring_number();

        System.out.println(f.solution(nums, 15));

    }
}
