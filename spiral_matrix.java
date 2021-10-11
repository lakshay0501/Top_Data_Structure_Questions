class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int n = arr.length;
        int m = arr[0].length;
        int tne = n*m;
        int cnt = 0;
        List<Integer> res =new ArrayList<Integer>();
        int k = 0;
        while (cnt < tne) {
            // Top Wall
            for(int i = minr, j = minc;  j <= maxc && cnt < tne; j++) {
                res.add(arr[i][j]);
                cnt++;
            }
            minr++;
            
            // Right Wall
            for(int i = maxc, j = minr;  j <= maxr && cnt < tne; j++) {
                res.add(arr[j][i]);
                cnt++;
            }
            maxc--;
            
            // Bottom Wall
            for(int j = maxr, i = maxc;  i >= minc && cnt < tne; i--) {
                res.add(arr[j][i]);
                cnt++;
            }
            maxr--;
            
            // Left Wall
            for(int j = minc, i = maxr; i >= minr && cnt < tne; i--) {
                res.add(arr[i][j]);
                cnt++;
            }
            minc++; 
        } 
        return res;
    }
}