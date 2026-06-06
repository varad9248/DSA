public class OderAgnosticBS {

    // suppose we have given an array which sorted but we dont know in which order they are sorted 
    // then we use OrderAgnosticsBinary search.

    public int  OderAgnosticBinarySearchS(int nums[] , int target){
        
        int start = 0;
        int end = nums.length -1;

        boolean isAsc = nums[start] < nums[end];

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;

            if(isAsc){
                if( target < nums[mid]) end  = mid - 1;
                else start = mid + 1;
            } else {
                if( target > nums[mid]) end  = mid - 1;
                else start = mid + 1;
            }
        }
        return  -1;
    }

    

    public static void main(String[] args) {
        
    }
}
