class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);        
        long happy=0;
        int l=0;
        for(int i=happiness.length-1;i>happiness.length-k-1;i--){
            int curr=happiness[i]-l;
            l++;
            if(curr<0){
                curr=0;
            }
            happy+=curr;
        }
        return happy;        
    }
}