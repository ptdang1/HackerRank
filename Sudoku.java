import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int num=1;
    static int count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[9][9];
        for(int a_i=0; a_i < 9; a_i++){
            for(int a_j=0; a_j < 9; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        //display(a);
        count = 0;
        Sudoku(a,0,0);
        if( count == 0 ) {
            System.out.println( "No solution exists");
        }
    }
    public static void Sudoku(int[][] arr,int r,int c) {
        //display(arr);
      if(c>8) {
        r+=1;
        c=0;
      }
      if(r>8) {
           display(arr);
           count++;
           return;
      }
      if(arr[r][c] != 0) {
        Sudoku(arr,r,c+1);
        return;
      }
         
      for(int i=1;i<=9 && count == 0;i++) {
        if(isPromising(arr,r,c,i)){
            arr[r][c]=i;
            Sudoku(arr,r,c+1);
        }
       }
       arr[r][c]=0;
   }
   
      public static boolean isPromising(int[][] arr,int r,int c,int num){
          for(int i=0;i<arr.length;i++){
            if(arr[r][i]==num)
                return false;
            if(arr[i][c]==num)
                return false;
          }
          int row=(r/3)*3;
          int col=(c/3)*3;
          int x=row;
          int y=col;
          
          for(int j=0;j<3;j++){
             for(int k=0;k<3;k++){
                if(arr[x+j][y+k]==num)
                    return false;
             }
          }
           return true;
      }
      public static void display(int[][] arr){
         //System.out.println("-----------------");
          for(int[]r:arr){
             for (int c : r){
               System.out.print(" "+c + " ");
             }
             System.out.println();
             }

          }
     }

