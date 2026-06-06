
public class Ceiling_number {

    /*
    
        This problem is about finding the Number is smallest but greater than or equal to the target in array.

        suppose you have array : {2,3,5,6,8,14,16,18}
        target is 15 then,

            if 15 is present then we return its index.
            if not then,

                we need to check the number which are greater than the target 15
                which are  {16,18}
                and we return the smallest number is this new array.
                so the answer will be 16 or the index 6
        
        In this problem we are searching the sorted array so best algorithm to use in this situation is 'binary search'

        by using the binary search we can eliminate our first condition of : 
            1. if element is present then return the index of it.

        problem remains is what if the number is not present in array.

        while using the binary search algorithm we use start and end pointers which track our current search block 
        i.e.  start < (required ans) < end   means our required answer should in the start or end.

        if number is not present then it met this condition i.e. end < start after icrements.

        in out case points should be lies like this ,

            s = 2 , e = 18 , m = 6, s = m + 1
            s = 8 , e = 18 , m = 14, s = m + 1
            s = 16 , e = 18 , m = 16 , e = m - 1
            s = 16 , e = 14 , end < start

            {2,3,5,6,8,14,16,18}
                        ^  ^ 
                        |  |
                      end  start

        we should return the start it will always the answer

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

        return start;

    }

    public static void main(String[] args) {
        
        int nums[] = {2,3,5,6,8,14,16,18};

        Ceiling_number c = new Ceiling_number();

        System.out.println(c.solution(nums, 15));

    }
}
