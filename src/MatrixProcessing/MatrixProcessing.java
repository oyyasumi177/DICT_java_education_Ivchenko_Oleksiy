package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] matrix = new int[n1][m1];
        for(int i=0;i<n1;i++) {
            for (int j = 0; j < m1; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int konst = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(matrix[i][j]*konst);
                if (j < m1 - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
