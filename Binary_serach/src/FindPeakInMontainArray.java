public class FindPeakInMontainArray {

/*
This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 

*/
    public int findInMountainArray(int target, int mountainArr[]) {

        int peak = findPeakElement(mountainArr);
        // find element inleft half
        int leftEle = OderAgnosticBinarySearchS(mountainArr , target , 0 , peak);
        if(leftEle != -1) return leftEle;
        // find in right half
        else return OderAgnosticBinarySearchS(mountainArr , target , peak , mountainArr.length - 1);
        
    }

    public int findPeakElement(int arr[]){
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


    public int  OderAgnosticBinarySearchS(int nums[] , int target , int start , int end){
        
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
}
