package org.example;

import java.util.Random;

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

}