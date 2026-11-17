class Solution {
    public String longestCommonPrefix(String[] str) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str[0].length();i++){
            char ch=str[0].charAt(i);
            for(int j=1;j<str.length;j++){
                if(i>=str[j].length() || str[j].charAt(i)!=ch){
                  return ans.toString();
                }
            }
            ans.append(ch);
        }
        return ans.toString();
    }
}