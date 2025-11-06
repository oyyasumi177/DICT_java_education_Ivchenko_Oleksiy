package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");

            int choice = sc.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1: // Додавання
                    System.out.print("Enter size of first matrix: > ");
                    int n1 = sc.nextInt();
                    int m1 = sc.nextInt();
                    Matrix A = new Matrix(n1, m1);
                    System.out.println("Enter first matrix:");
                    A.read(sc);

                    System.out.print("Enter size of second matrix: > ");
                    int n2 = sc.nextInt();
                    int m2 = sc.nextInt();
                    Matrix B = new Matrix(n2, m2);
                    System.out.println("Enter second matrix:");
                    B.read(sc);

                    Matrix sum = Matrix.add(A, B);
                    if (sum == null) {
                        System.out.println("The operation cannot be performed.");
                    } else {
                        System.out.println("The result is:");
                        sum.print();
                    }
                    break;

                case 2: // Множення на константу
                    System.out.print("Enter size of matrix: > ");
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    Matrix M = new Matrix(n, m);
                    System.out.println("Enter matrix:");
                    M.read(sc);

                    System.out.print("Enter constant: > ");
                    double k = sc.nextDouble();

                    Matrix resultConst = M.multiplyByConstant(k);
                    System.out.println("The result is:");
                    resultConst.print();
                    break;

                case 3: // Множення матриць
                    System.out.print("Enter size of first matrix: > ");
                    int r1 = sc.nextInt();
                    int c1 = sc.nextInt();
                    Matrix X = new Matrix(r1, c1);
                    System.out.println("Enter first matrix:");
                    X.read(sc);

                    System.out.print("Enter size of second matrix: > ");
                    int r2 = sc.nextInt();
                    int c2 = sc.nextInt();
                    Matrix Y = new Matrix(r2, c2);
                    System.out.println("Enter second matrix:");
                    Y.read(sc);

                    Matrix product = Matrix.multiply(X, Y);
                    if (product == null) {
                        System.out.println("The operation cannot be performed.");
                    } else {
                        System.out.println("The result is:");
                        product.print();
                    }
                    break;
                case 4:
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    System.out.print("Your choice: > ");
                    int transposeChoice = sc.nextInt();
                    System.out.print("Enter size of matrix: > ");
                    int q = sc.nextInt();
                    int w = sc.nextInt();
                    Matrix P = new Matrix(q, w);
                    System.out.println("Enter matrix:");
                    P.read(sc);

                    Matrix result = null;
                    switch (transposeChoice) {
                        case 1: result = P.transposeMainDiagonal(); break;
                        case 2: result = P.transposeSideDiagonal(); break;
                        case 3: result = P.transposeVertical(); break;
                        case 4: result = P.transposeHorizontal(); break;
                        default: System.out.println("Invalid choice!"); continue;
                    }

                    System.out.println("The result is:");
                    result.print();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public void read(Scanner sc) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = sc.nextDouble();
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j]);
                if (j < cols - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static Matrix add(Matrix a, Matrix b) {
        if (a.rows != b.rows || a.cols != b.cols) return null;
        Matrix result = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++)
            for (int j = 0; j < a.cols; j++)
                result.data[i][j] = a.data[i][j] + b.data[i][j];
        return result;
    }

    public Matrix multiplyByConstant(double k) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = data[i][j] * k;
        return result;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.cols != b.rows) return null;
        Matrix result = new Matrix(a.rows, b.cols);
        for (int i = 0; i < a.rows; i++)
            for (int j = 0; j < b.cols; j++) {
                double sum = 0;
                for (int k = 0; k < a.cols; k++)
                    sum += a.data[i][k] * b.data[k][j];
                result.data[i][j] = sum;
            }
        return result;
    }
    public Matrix transposeMainDiagonal() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[j][i] = data[i][j];
        return result;
    }

    public Matrix transposeSideDiagonal() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[cols-1-j][rows-1-i] = data[i][j];
        return result;
    }

    public Matrix transposeVertical() {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][cols-1-j] = data[i][j];
        return result;
    }

    public Matrix transposeHorizontal() {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[rows-1-i][j] = data[i][j];
        return result;
    }
}