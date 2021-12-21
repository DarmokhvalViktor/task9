package org.darmokhval.tasks9;


public class Matrix {
    private final int row;
    private final int column;
    private final double[][] actualMatrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.actualMatrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.actualMatrix[i][j] = 0;
            }
        }
    }
    public Matrix(double[][] twoDimensionalArray) {
        this.row = twoDimensionalArray.length;
        this.column = twoDimensionalArray[0].length;
        this.actualMatrix = twoDimensionalArray;
    }
    public int getRow() {
        return this.row;
    }
    public int getColumn() {
        return this.column;
    }
    public double[][] getMatrix() {
        return actualMatrix;
    }
    public double getElement(int row, int column) {
        return actualMatrix[row][column];
    }
    public void setElement(int row, int column, double newElem) {
        actualMatrix[row][column] = newElem;
    }
    public Matrix addition(Matrix matrix) {
        Matrix matrixAddition = new Matrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                matrixAddition.setElement(i, j, actualMatrix[i][j] + matrix.getElement(i, j));
            }
        }
        return matrixAddition;
    }
    public Matrix subtraction(Matrix matrix) {
        Matrix matrixSubtraction = new Matrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                matrixSubtraction.setElement(i, j, actualMatrix[i][j] - matrix.getElement(i, j));
            }
        }
        return matrixSubtraction;
    }
    public Matrix multiplication(Matrix matrix) {
        Matrix matMult = new Matrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < matrix.getColumn(); j++) {
                for (int k = 0; k < getColumn(); k++) {
                    matMult.setElement(i, j, matMult.getElement(i, j) + actualMatrix[i][k] * matrix.getElement(k, j));
                }
            }
        }
        return matMult;
    }
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < this.getRow(); i++) {
            for (int j = 0; j < this.getColumn(); j++) {
                build.append(getElement(i, j)).append(" ");
            }
            build.append("\n");
        }
        return build.toString();
    }

    public static void main(String[] args) {
        // Чи можна заповнити матрицю послідовністю чисел не використовуючи цикли?
        Matrix mat1 = new Matrix(3, 3);
        int count = 1;
        for (int i = 0; i < mat1.getRow(); i++) {
            for (int j = 0; j < mat1.getColumn(); j++) {
                mat1.setElement(i, j, count++);
            }
        }

        Matrix mat2 = new Matrix(3, 3);
        count = 10;
        for (int i = 0; i < mat2.getRow(); i++) {
            for (int j = 0; j < mat2.getColumn(); j++) {
                mat2.setElement(i, j, count++);
            }
        }

        Matrix a = mat1.multiplication(mat2);
        Matrix b = mat1.addition(mat2);
        Matrix c = mat2.subtraction(mat1);
        System.out.println();
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}
