package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Immutable {
    private int rows;
    private int columns;
    private float[][] data;

    public Immutable(){}

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

    //Конструктор для стоворення рандомної матриці
    public void random(int rows, int columns, int minValue, int maxValue) {
        this.data = new float[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int randomInt = random.nextInt(maxValue - minValue + 1) + minValue;
                data[i][j] = randomInt;
            }
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

    // Метод для додавання матриць
    public Immutable add(Matrix other) {
        System.out.println("Дану операцію не можна провести з класом Immutable");
        return null;
    }

    // Метод для множення на скаляр
    public Immutable scalarM(float scalar) {
        System.out.println("Дану операцію не можна провести з класом Immutable");
        return null;
    }

    //Метод для стоворення діагональної матриці на основі вектора
    public void diagonalImm(float[] vector) {
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
    public void identityImm(int n){
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

    //Метод для стоворення рандомної матриці-строки
    public void randomRowImm(int n){
        this.rows = n;
        this.columns = 1;
        this.data = new float[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextFloat();;
            }
        }
    }

    //Метод для стоворення рандомної матриці-стовпця
    public void randomCoulumnImm(int n){
        this.rows = 1;
        this.columns = n;
        this.data = new float[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextFloat();;
            }
        }
    }

    // Метод для виведення матриці на екран
    public void printImmutable() {
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
