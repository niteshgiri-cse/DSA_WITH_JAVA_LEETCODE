class Solution {
    public int minimumLength(String s) {
        int st=0,end=s.length()-1;
        while(st<end && s.charAt(st)==s.charAt(end)){
            char ch=s.charAt(st);
            while(st<=end && s.charAt(st)==ch){
                st++;
            }
            while(st<=end && s.charAt(end)==ch){
                end--;
            }
        }
        return end-st+1;
    }
}