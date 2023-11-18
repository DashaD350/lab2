package org.example;

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

    //Метод для стоворення рандомної матриці
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

}