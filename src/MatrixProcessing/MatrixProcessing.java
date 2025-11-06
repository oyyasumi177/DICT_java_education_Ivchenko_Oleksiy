package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] matrix = new int[n1][m1];
        for(int i=0;i<n1;i++){
            for(int j=0;j<m1;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        int[][] matrix2 = new int[n2][m2];
        for(int i=0;i<n2;i++){
            for(int j=0;j<m2;j++){
                matrix2[i][j] = sc.nextInt();
            }
        }
        if (n1 != n2 || m1 != m2) {
            System.out.println("ERROR");
            return; // завершуємо програму
        }
        int[][] matrix3 = new int[n1][m1];
        for(int i=0;i<n2;i++){
            for(int j=0;j<m2;j++){
                matrix3[i][j] = matrix[i][j] +  matrix2[i][j];
            }
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(matrix3[i][j]);
                if (j < m1 - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
