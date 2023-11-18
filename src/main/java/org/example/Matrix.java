package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private int rows;
    private int columns;
    private float[][] data;

    public Matrix(){}

    // Конструктор для створення порожньої матриці
    public void emptyMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new float[rows][columns];
    }

    // Конструктор для створення копії іншої матриці
    public void copyMatrix (Matrix other) {
        this.rows = other.rows;
        this.columns = other.columns;
        this.data = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(other.data[i], 0, this.data[i], 0, columns);
        }
    }

    //Конструктор для стоворення рандомної матриці
    public void random(int rows, int columns){
        this.data = new float[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextFloat();;
            }
        }
    }

    // Метод для заповнення матриці значеннями
    public void fillMatrix(int rows, int columns) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть значення для матриці " + rows + "x" + columns + ":");
        this.rows = rows;
        this.columns = columns;
        this.data = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Елемент [" + (i + 1) + "][" + (j + 1) + "]: ");
                data[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }
    }

    // Метод для отримання рядка матриці
    public void getRow(int row) {
        System.out.println("Шуканий рядок " + row + ": ");
        for (int j = 0; j < columns; j++)
            System.out.print(data[row-1][j] + " ");
        System.out.println();
    }

    // Метод для отримання стовпця матриці
    public void getColumn(int column) {
        System.out.println("Шуканий стовпець " + column + ": ");
        for (int i = 0; i < rows; i++)
            System.out.print(data[i][column-1] + " ");
        System.out.println();
    }

    // Метод для отримання значення конкретного елемента матриці
    public double getElement(int row, int column) {
        System.out.println("Шуканий елемент [" + row + "][" + column + "]: ");
        double el = data[row-1][column-1];
        return el;
    }

    // Метод для отримання розмірності матриці
    public void getDimension() {
        System.out.println("Матриця має розмірність: " + rows + " x " + columns);
    }

    //Метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Matrix other = (Matrix) obj;
        if (obj == null || getClass() != obj.getClass()) return false;
        for (int i = 0; i < rows; i++) {
            if (!Arrays.equals(data[i], other.data[i])) return false;
        }
        for (int i = 0; i < columns; i++) {
            if (!Arrays.equals(data[i], other.data[i])) return false;
        }
        return true;
    }

    //Метод hashCode
    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(data);
        return result;
    }

    // Метод для додавання матриць
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Розміри матриць не співпадають");
        }
        Matrix result = new Matrix();
        System.out.println("Ваша нова матриця: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

    // Метод для множення на скаляр
    public void scalarM(float scalar) {
        Matrix result = new Matrix();
        System.out.println("Ваша нова матриця: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = this.data[i][j] * scalar;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для множення матриць
    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Несумісна розмірність");
        }
        Matrix result = new Matrix();
        System.out.println("Ваша нова матриця: ");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                float sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                data[i][j] = sum;
            }
        }
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

    // Метод для отримання транспонованої матриці
    public void transp() {
        float[][] newData = new float[columns][rows];
        System.out.println("Ваша транспонована матриця: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newData[j][i] = data[i][j];
            }
        }
        data = newData;
        int temp = rows;
        rows = columns;
        columns = temp;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Метод для стоворення діагональної матриці на основі вектора
    public void diagonal(float[] vector) {
        this.rows = vector.length;
        this.columns = vector.length;
        this.data = new float[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    data[i][j] = vector[i];
                } else {
                    data[i][j] = 0.0f;
                }
            }
        }
    }

    //Метод для стоворення одиничної матриці
    public void identity(int n){
        this.rows = n;
        this.columns = n;
        this.data = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    data[i][j] = 1;
                } else {
                    data[i][j] = 0.0f;
                }
            }
        }
    }

    // Метод для виведення матриці на екран
    public void printMatrix() {
        System.out.println("Ваша матриця: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}