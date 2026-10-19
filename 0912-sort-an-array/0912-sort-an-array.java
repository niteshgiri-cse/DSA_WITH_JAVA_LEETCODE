class Solution {
        public void mergeSort(int[] nums,int left ,int mid,int right){
            int[]temp=new int[right-left+1];
            int i=left;
            int j=mid+1;
            int k=0;
            while(i<=mid && j<=right){
                if(nums[i]<=nums[j]){
                    temp[k++]=nums[i++];
                }else{
                    temp[k++]=nums[j++];
                }
            }
            while(i<=mid){
                temp[k++]=nums[i++];
            }
            while(j<=right){
                temp[k++]=nums[j++];
            }
           for(int p=0;p<temp.length;p++){
                nums[left+p]=temp[p];
           } 

        }
        public void merge(int[] nums,int left,int right){
            if(left>=right) return;
            int mid=left+(right-left)/2;
            merge(nums,left,mid);
            merge(nums,mid+1,right);
            mergeSort(nums,left,mid,right);
        }
        public int[] sortArray(int[] nums) {
             int left=0,right=nums.length-1;
             merge(nums,left,right);
             return nums;
 
    }   
}