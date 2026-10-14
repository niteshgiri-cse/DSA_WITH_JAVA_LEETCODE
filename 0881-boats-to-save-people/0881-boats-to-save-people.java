class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count=0,left=0,right=people.length-1;
        while(left<=right){
            int weg=people[left]+people[right];
            if(weg<=limit){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}