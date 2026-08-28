class Solution {
    public void swap(int[][] mat, int i) {
        int s = 0;
        int e = mat[i].length - 1;
        while (s <= e) {
            int temp = mat[i][e];
            mat[i][e] = mat[i][s];
            mat[i][s] = temp;
            s++;
            e--;
        }
    }

    public void rotate(int[][] mat) {
        int m = mat.length; // row 
        int n = mat[0].length; // col 
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            swap(mat, i);
        }
    }
}