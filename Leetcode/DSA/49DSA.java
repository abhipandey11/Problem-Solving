class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map <String,List<String>> map=new HashMap<>();

        for(String str: strs){
            String news=generate(str);

            if(!map.containsKey(news)){
                map.put(news,new ArrayList<>());
            }
            map.get(news).add(str);
        }
        return new ArrayList<>(map.values());
        
    }
    public String generate(String str){
        int hash[]=new int[26];

        for(char ch:str.toCharArray()){
            hash[ch-'a']++;
        }
        StringBuilder news=new StringBuilder();
        for(int i=0;i<26;i++){
          if(hash[i]>0){
            news.append(String.valueOf((char)(i+'a')).repeat(hash[i]));
          }
        }

        return news.toString();
    }
}

/*------------------------------------------------------------------------- */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
