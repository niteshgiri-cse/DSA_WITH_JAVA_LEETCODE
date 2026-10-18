class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n=arr.length;
        int totalSum = 0;
        int maxEnding = arr[0], maxSum = arr[0];
        int minEnding = arr[0], minSum = arr[0];

        totalSum = arr[0];

        for (int i = 1; i < n; i++) {
            totalSum += arr[i];

            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(arr[i], minEnding + arr[i]);
            minSum = Math.min(minSum, minEnding);
        }

        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}