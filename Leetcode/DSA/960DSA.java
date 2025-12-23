class Solution {
    public int minDeletionSize(String[] strs) {
        int l=strs[0].length();
        int dp[]=new int[l];
        int max=0;
        for(int i=0;i<l;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(isValid(strs,i,j)){
                    dp[i]=Math.max(dp[i],dp[j]+1);                  
                }
            }
            max=Math.max(max,dp[i]);
        }

        return l-max;
        
    }
    public boolean isValid(String strs[], int i,int j){
        for(int k=0;k<strs.length;k++){
            if(strs[k].charAt(j)>strs[k].charAt(i))
            return false;
        }
        return true;
    }
}