class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(x,y)->Integer.compare(x[0],y[0]));
        int stIdx=left;
        for(int[] interval:ranges){
            int st=interval[0];
            int end=interval[1];
            if(stIdx>end) continue;
            if(st>stIdx) return false;
            stIdx=end+1;
            if(stIdx>right) return true;
        }
        return false;
    }
}