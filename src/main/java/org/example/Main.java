package org.example;

public class Main {
    public static void main(String[] args) {

        Matrix mat = new Matrix();
        Matrix mat1 = new Matrix();
        Matrix mat2 = new Matrix();
        Matrix mat3 = new Matrix();
        Immutable mat4 = new Immutable();
        mat1.random(3,3,1,10);
        //mat1.fillMatrix(3,3);
        //mat1.printMatrix();

        /*mat.emptyMatrix(2,2);
        mat.printMatrix();
        mat.fillMatrix(2,1);
        mat.printMatrix();
        mat2.copyMatrix(mat);
        mat2.printMatrix();*/
        /*mat2.getDimension();
        System.out.println(mat1.getElement(1, 3));
        mat1.getRow(2);
        mat2.getColumn(1);
        System.out.println(mat.equals(mat2));
        System.out.println(mat1.hashCode());
        System.out.println(mat2.hashCode());
        mat1.add(mat);
        mat1.scalarM(2.5f);
        mat1.multiply(mat);
        mat1.transp();
        double [] vector = { 1, 2, 2, 3};
        mat2.diagonal(vector);
        mat2.printMatrix();
        int n = 5;
        mat2.identity(n);
        mat2.printMatrix();
        mat.randomCoulumn(n);
        mat.printMatrix();
        mat1.luDecomp(3);*/

    }
}