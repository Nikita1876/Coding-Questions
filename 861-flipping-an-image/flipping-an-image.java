class Solution {
      public int[][] flipAndInvertImage(int[][] image) {

        int i = 0;
        while (i < image.length) {
            int j = 0;
            int k = image[i].length - 1;

            while (j < k) {
                int temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;

                j++;
                k--;
            }
            i++;
        }

        int row = 0;
        while (row < image.length) {
            int col = 0;

            while (col < image[row].length) {
                if (image[row][col] == 1)
                    image[row][col] = 0;
                else
                    image[row][col] = 1;

                col++;
            }
            row++;
        }

        return image;
    }
}
