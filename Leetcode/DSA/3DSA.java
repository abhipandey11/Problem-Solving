// 3. Longest Substring Without Repeating Characters
//BRUTEFORCE APPROACH  O(N^2)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int res=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character> set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                
            }
            res=Math.max(res,set.size());
        }
        return res;
        
    }
}

//SLIDING WINDOW APPROACH O(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();       
        int res=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));            
            res=Math.max(res,r-l+1);
        }
        return res;
        
    }
}

//OPTIMISED SLIDING WINDOW APPROACH O(N)

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