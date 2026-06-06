public class InfiniteArraySearch {
    
    public static void main(String[] args) {
        
        int nums[] = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20};

        InfiniteArraySearch ias  = new InfiniteArraySearch();
        
        System.out.println( ias.search(nums, 10));
    }

    public boolean search(int nums[] , int target){

        boolean isPresent = false;

        // we need to find the start and end pointers
        int start = 0 ;
        int end  = 1;

        // we increment the start and end window by 2 till we get target within start and end range
        // i.e.  start < target < end
        while(target > nums[end]){
            int temp = end + 1;
            end  = end + (end - start + 1) * 2;
            start = temp;
        }

        // now we find the range window just use the binary search
        isPresent = binarySearch(nums, start, end, target);

        // return the answer if the element is presnt or not
        return isPresent;
    }

    public boolean  binarySearch(int nums[] , int start , int end , int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            else if( target < nums[mid]) end  = mid - 1;
            else start = mid + 1;
        }
        return  false;
    }
}
