class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROW=matrix.length;
        int COLS=matrix[0].length;
        int start=0;int end=ROW-1;
        int row=-1;
        while(start<=end){
            row=start+(end-start)/2;
            if(matrix[row][COLS-1]<target){
                start=row+1;
            }
            else if(matrix[row][0]>target){
                end=row-1;
            }
            else{
                break;
            }
        }

        while(!(start<=end)){
            return false;
        }

        int l=0;
        int r=COLS-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(matrix[row][m]>target){
                r=m-1;
            }
            else if(matrix[row][m]<target){
                l=m+1;
            }
            else{
                return true;
            }
        }
        return false;

        
    }
}