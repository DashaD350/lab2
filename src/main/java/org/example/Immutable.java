package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Immutable {
    private int rows;
    private int columns;
    private float[][] data;

    // Конструктор для створення порожньої матриці
    public void emptyImmutable(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new float[rows][columns];
    }

    // Конструктор для створення копії іншої матриці
    public void copyImmutable (Immutable other) {
        this.rows = other.rows;
        this.columns = other.columns;
        this.data = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(other.data[i], 0, this.data[i], 0, columns);
        }
    }

    // Метод для заповнення матриці значеннями
    public void fillImmutable(int rows, int columns) {
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

    // Метод для отримання розмірності матриці
    public void getDimensionImm() {
        System.out.println("Матриця має розмірність: " + rows + " x " + columns);
    }

    // Метод для отримання рядка матриці
    public void getRowImm(int row) {
        System.out.println("Шуканий рядок " + row + ": ");
        for (int j = 0; j < columns; j++)
            System.out.print(data[row-1][j] + " ");
        System.out.println();
    }

    // Метод для отримання стовпця матриці
    public void getColumnImm(int column) {
        System.out.println("Шуканий стовпець " + column + ": ");
        for (int i = 0; i < rows; i++)
            System.out.print(data[i][column-1] + " ");
        System.out.println();
    }

    // Метод для отримання значення конкретного елемента матриці
    public void getElementImm(int row, int column) {
        System.out.println("Шуканий елемент [" + row + "][" + column + "]: ");
        double el = data[row-1][column-1];
        System.out.println(el);
        System.out.println();
    }

    //Метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Immutable other = (Immutable) obj;
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

}
