public class SearchBSIn2DArray {
    public static void main(String[] args) {
        
        int matrrix[][] = {
            {10 ,20 ,30 , 40},
            {50, 60, 70, 80},
            {90, 100, 110 ,120},
            {130 ,140, 150, 160}
        };

        System.out.println( "Ans : "  +search(matrrix, 100));

    }

    // simple binary search
    public int binarySearch(int nums[], int start , int end , int target){
        while(start <= end ){
            
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    // we can use this in Row level Sroted matrrix
    public static  boolean search(int matrrix[][], int target){

        int n = matrrix.length;
        int m = matrrix[0].length;

        int i = 0;
        int j = m - 1;

        while(i < n && j >= 0){
            if(matrrix[i][j] == target) {
                return true;
            } else if (target < matrrix[i][j] ){
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    // pure binary serach in 2D sorted matrix

    public int[] serachIn2DSorted(int matrix[][] , int target ){

        

        return new int[] {-1, -1};

    }

}
