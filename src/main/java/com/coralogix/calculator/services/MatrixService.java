package com.coralogix.calculator.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class MatrixService {

	public void generateMatrix(Integer value) {
		int[][] matrix= new int [10][10];
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				int temp = 0;
				if(i == 0) {
					temp =  matrix[0][j];
				} else {
					temp =  matrix[i-1][j];
				}
				matrix[i][j] = (value * i ) + temp;  
			}
		}
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
	}
}
