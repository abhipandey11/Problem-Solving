import java.util.*;
class Solution {
    public int minDeletionSize(String[] strs) {

        int n=strs[0].length();
        int count=0;
        int s=strs.length;
        boolean alreadysorted[]=new boolean[s];
        Arrays.fill(alreadysorted,false);
        boolean deleted;
        for(int i=0;i<n;i++){
            deleted=false;
            for(int j=1;j<s;j++){
                if(!alreadysorted[j-1]&&strs[j-1].charAt(i)>strs[j].charAt(i))
                {count++;
                deleted=true;
                break;                    
                }
            }
            if(deleted){
                continue;
            }
            for(int k=1;k<s;k++){
                alreadysorted[k-1]=alreadysorted[k-1]||(strs[k-1].charAt(i)<strs[k].charAt(i));
            }

        }
        return count;
        
    }
}