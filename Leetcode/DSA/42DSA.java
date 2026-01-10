class Solution {
    public int trap(int[] height) {
        int maxl=0;int maxr=0;
        int left=0;
        int right=height.length-1;
        int water=0;
        while(left<right){
            if(height[left]<height[right]){
                maxl=Math.max(height[left],maxl);
                water+=maxl-height[left];
                left++;
            }
            else{
                maxr=Math.max(height[right],maxr);
                water+=maxr-height[right];
                right--;
            }
        }
        return water;
        
    }
}