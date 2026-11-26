class Solution {
    boolean isValid(int[] piles,int k,int h){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(piles[i]+k-1)/k;
            if(hours> h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int st=1;
        int end=0;
        for(int pile:piles){
            end=Math.max(end,pile);
        }
        int ans=end;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isValid(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
}