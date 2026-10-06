class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int count=0;
        int runningsum=0;
        for(int i=0;i<arr.length;i++){
            runningsum+=arr[i];
            int rem=runningsum%k;
            if (rem < 0) {
            rem = rem + k;
            }
            if(mp.containsKey(rem)){
                count+=mp.get(rem);
            }
            mp.put(rem,mp.getOrDefault(rem,0)+1);
        }
        return count;
    }
}