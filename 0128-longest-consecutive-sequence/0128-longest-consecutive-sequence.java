class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int maxLen=0;
        for(int ele:st){
            int prevEl=ele-1;
            if(!st.contains(prevEl)){
                int len=1;
                int nextEle=ele+1;
                while(st.contains(nextEle)){
                    len++;
                    nextEle++;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;

    }
}