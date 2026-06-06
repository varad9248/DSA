class FindPeakElementInArray {

    /*
        

        you are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
        Return the index of the peak element.
        Your task is to solve it in O(log(n)) time complexity.

        Example 1:
        Input: arr = [0,1,0]
        Output: 1

        Example 2:
        Input: arr = [0,2,1,0]
        Output: 1

        Example 3:
        Input: arr = [0,10,5,2]
        Output: 1

    */


    public int peakIndexInMountainArray(int[] arr) {
        
        int start = 0;
        int end  = arr.length - 1;

        // base condition when start < end 
        while(start < end){

            // find mid as usual
            int mid = start + (end - start) / 2;

            // cond. 1. when our mid lies in the descening slide of the array there might greater elements in array
            if(arr[mid] > arr[mid + 1]){
                // desending order of array
                end = mid; // we take out large elemenet in both array becuase we need to find the peak element as our end.
            } 
            // cond. 2. when our mid lies in the ascening slide of the array there might greater elements in array
            else{
                // asending order of array
                start = mid + 1; // we take larger element as per the condtion of peak element.
            }

        }

        // at last start == end means both lies on the same index in array. 
        return start;

    }

    public static void main(String[] args) {
        
    }
}