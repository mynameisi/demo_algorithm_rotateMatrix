package demo_algorithm_rotateMatrix;

/**
 * 这个程序可以顺时针旋转一个多维数组</br>
 * 比如：</br>
 * 1 2 3</br>
 * 4 5 6</br>
 * 7 8 9</br>
 * 程序运行后的结果是</br>
 * 7 4 1</br>
 * 8 5 2</br>
 * 9 6 3</br>
 * 把一张图片想象称为一个M*N格的二维数组</br>
 * 这个小程序就能实现图片的顺时针旋转</br>
 * 
 * @author wangguozheng
 *
 */
public class RotateMatrix {
	public static void main(String[] args){
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		RotateMatrix.rotate(matrix, matrix.length);
		RotateMatrix.printMatrix(matrix);
		
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix, int n) { 
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer; 
			int last = n-1-layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top; // right <- saved top }
			} 
		}
	}
}
