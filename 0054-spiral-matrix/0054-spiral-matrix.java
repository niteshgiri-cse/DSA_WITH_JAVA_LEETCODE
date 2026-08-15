class Solution {

    public void solve(int[][] matrix, List<Integer> output) {

        int m = matrix.length;
        int n = matrix[0].length;

        int srow = 0, scol = 0;
        int erow = m - 1, ecol = n - 1;

        int count = 0;
        int total = m * n;

        while (count < total) {

            // Top
            for (int j = scol; j <= ecol && count < total; j++) {
                output.add(matrix[srow][j]);
                count++;
            }
            srow++;

            // Right
            for (int i = srow; i <= erow && count < total; i++) {
                output.add(matrix[i][ecol]);
                count++;
            }
            ecol--;

            // Bottom
            for (int j = ecol; j >= scol && count < total; j--) {
                output.add(matrix[erow][j]);
                count++;
            }
            erow--;

            // Left
            for (int i = erow; i >= srow && count < total; i--) {
                output.add(matrix[i][scol]);
                count++;
            }
            scol++;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();

        solve(matrix, output);

        return output;
    }
}