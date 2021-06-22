package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] mat = new int [n][n];

        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                mat[x][y] = sc.nextInt();
            }
        }

        sc.close();
    }
}
