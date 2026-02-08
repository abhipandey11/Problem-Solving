// 424. Longest Repeating Character Replacement
//BRUTEFORCE APPROACH O(N^2)

class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> count=new HashMap<>();
            int max=0;
            for(int j=i;j<s.length();j++){
                count.put(s.charAt(j),count.getOrDefault(s.charAt(j),0)+1);
                max=Math.max(max,count.get(s.charAt(j)));
                if(j-i+1-max<=k){
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
        
    }
}

//SLIDING WINDOW APPROACH O(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map=new HashMap<>();       
        int res=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(map.get(s.charAt(r))+1,l);
            }
            map.put(s.charAt(r),r);            
            res=Math.max(res,r-l+1);
        }
        return res;
        
    }
}