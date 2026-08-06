class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        int uniqueWindowSize=mp.size();
        int windowStartIdx=-1;
        int minWindowSize=Integer.MAX_VALUE;
        int currWindowStartIdx=0;
        int loopIdx=0;
        while(loopIdx<s.length()){
            char ch=s.charAt(loopIdx);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0){
                    uniqueWindowSize--;
                }
            }
            while(uniqueWindowSize==0){
                int len=loopIdx-currWindowStartIdx+1;
                if(len<minWindowSize){
                    minWindowSize=len;
                    windowStartIdx=currWindowStartIdx;
                }
                ch=s.charAt(currWindowStartIdx);
                if(mp.containsKey(ch)){
                    mp.put(ch,mp.get(ch)+1);
                    if(mp.get(ch)>0) uniqueWindowSize++;
                }
                currWindowStartIdx++;
            }

            loopIdx++;
        }
        return windowStartIdx== -1 ? "":s.substring(windowStartIdx,windowStartIdx+minWindowSize);




    }
}