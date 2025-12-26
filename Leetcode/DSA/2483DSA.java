class Solution {
    public int bestClosingTime(String customers) {
        int close=Integer.MAX_VALUE;
        int n=customers.length();
        int []prefix=new int[n+1];
        int []suffix=new int[n+1];
        int index=0;
        prefix[0]=0;
        for(int i=1;i<=customers.length();i++){
            if(customers.charAt(i-1)=='N')
            prefix[i]=prefix[i-1]+1;
            else
            prefix[i]=prefix[i-1];
        }

        for(int i=n-1;i>=0;i--){
            if(customers.charAt(i)=='Y')
            suffix[i]=suffix[i+1]+1;
            else
            suffix[i]=suffix[i+1];
        }
        for(int i=0;i<=n;i++){
            if(prefix[i]+suffix[i]<close){
                close=prefix[i]+suffix[i];
                index=i;
            }
        }
        return index;

        
    }
}