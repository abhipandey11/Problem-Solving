class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=0;
        int r=Arrays.stream(piles).max().getAsInt();
        int res=r;
        while(l<=r){
            int k=0;
            int s=l+(r-l)/2;
            for(int p:piles){
                k+=Math.ceil((double)p/s);
            }
            if(k<=h){
                res=s;
                r=s-1;
            }
            else{
                l=s+1;
            }
        }
        return res;
        
    }
}