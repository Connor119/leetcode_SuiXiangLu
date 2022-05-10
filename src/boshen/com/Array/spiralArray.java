package boshen.com.Array;

import java.util.ArrayList;
import java.util.List;

public class spiralArray {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        // 当左指针超过了右指针停下，同理上指针超过了下指针停下
        // 由于右指针和下指针是有意义的闭区间，所以要有等于号
        while(left<=right && top <= bottom){
            for(int i = left; i<=right;i++){
                res.add(matrix[top][i]);
            }
            for (int row1 = top + 1; row1 <= bottom; row1++) {
                res.add(matrix[row1][right]);
            }

            if (left < right && top < bottom) {
                for(int k = right-1 ; k > left ; k--){
                    res.add(matrix[bottom][k]);
                }
                for(int x = bottom ; x> top;x--){
                    res.add(matrix[x][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
