class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        if(set.size()<nums.length){
            return true;
        }
        return false;
        
    }
}
/*------------------------------------------------------------------------ */

boolean[] seen = new boolean[100001];
for (int x : nums) {
    if (seen[x]) return true;
    seen[x] = true;
}
return false;
