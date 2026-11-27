class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer,Integer> mp=new HashMap<>();
         for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
         }                         
         PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> mp.get(a)-mp.get(b));
         for(int key :mp.keySet()){
            pq.offer(key);
            if(pq.size()>k){
                pq.poll();
            }
         } 
         int[] ans=new int[k];
         for(int i=0;i<k;i++){
            ans[i]=pq.poll();
         }
         return ans;
    }
}