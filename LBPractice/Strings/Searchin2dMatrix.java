package LoveBabbar.Strings;

public class Searchin2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j = matrix[0].length-1;

        while(i<matrix.length){
            if(matrix[i][0] ==target || matrix[i][j] ==target){
                return true;
            }
            if(target>matrix[i][0] && target<matrix[i][j]){
                break;
            }
            i++;
        }
        if(i==matrix.length){
            return false;
        }
        for(int x=0;x<j;x++){
            if(matrix[i][x]==target){
                return true;
            }
        }
        return false;
    }
    // n m hi more clear
//    int i = 0, j = matrix[0].length - 1;
//            while (i < matrix.length && j >= 0) {
//        if (matrix[i][j] == target) {
//            return true;
//        } else if (matrix[i][j] > target) {
//            j--;
//        } else {
//            i++;
//        }
//    }
//
//            return false;
//

    // optimized logn wala

//    Use binary search.
//
//            n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
//
//    an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

    
//public boolean searchMatrix(int[][] matrix, int target) {
//    if (matrix == null || matrix.length == 0) {
//        return false;
//    }
//    int start = 0, rows = matrix.length, cols = matrix[0].length;
//    int end = rows * cols - 1;
//    while (start <= end) {
//        int mid = (start + end) / 2;
//        if (matrix[mid / cols][mid % cols] == target) {
//            return true;
//        }
//        if (matrix[mid / cols][mid % cols] < target) {
//            start = mid + 1;
//        } else {
//            end = mid - 1;
//        }
//    }
//    return false;
//}

}
