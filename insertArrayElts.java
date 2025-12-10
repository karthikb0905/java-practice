

import java.util.Scanner;

public class insertArrayElts {
    public static void insert(int arr[][],int row,int col) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = sc.nextInt();

            }
        }
        
    }
    public static void print(int arr[][],int row,int col) {
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+"");

            }
            System.err.println();
        }
    }
    public static void main(String[] args) {
        int row,col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row size");
        row = sc.nextInt();
        System.err.println("Enter Colsize");
        col = sc.nextInt();
        int arr[][] = new int[row][col];
        insert(arr,row,col);
        print(arr,row,col);

    }
}