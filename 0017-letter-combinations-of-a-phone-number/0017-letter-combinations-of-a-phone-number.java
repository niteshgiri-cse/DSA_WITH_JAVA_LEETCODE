class Solution {
    static void solve(String digits, int index,String[] mapping,
    List<String> result, StringBuilder output){
        //base case
        if(index>=digits.length()){
            result.add(output.toString());
            return;
        }
        // 1case  mujhe solve karna hai , baki recursion dekh lega
        int value=digits.charAt(index)-'0';
        String mappedString=mapping[value];
        //current value and uski mapped string mere pass ready hai 
        //current block par use rakh dete hai 
        for(int i=0;i<mappedString.length();i++){
            output.append(mappedString.charAt(i));
            solve(digits,index+1,mapping,result,output);
            //backtracking or undo step
            output.deleteCharAt(output.length()-1);
        }


    }
    public List<String> letterCombinations(String digits) {
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result=new ArrayList<>();
        StringBuilder output=new StringBuilder();
        int index=0;
        solve(digits,index,mapping,result,output);
        return result;


    }
}