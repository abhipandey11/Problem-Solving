//O(nlogk) time complexity
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int n:map.keySet()){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int result[]=new int[k];

        for(int i=0;i<k;i++){
            result[i]=pq.poll();
        }

        return result;
        
    }
}
/*----------------------------------------------- */
//O(nlogn) time complexity
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a, b) -> freq.get(b) - freq.get(a));

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = keys.get(i);

        return res;
    }
}
