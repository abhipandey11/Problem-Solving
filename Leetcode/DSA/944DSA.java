class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int l=strs.length;
        int del=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<l;j++){
                if(strs[j-1].charAt(i)<=strs[j].charAt(i))
                    continue;
                else{
                    del++;
                    break;
                }
            }
        }
        return del;
        
    }
}