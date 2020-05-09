package Practica13;

import java.util.Arrays;

public class Ajedrez {

	public static void main(String[] args) {
		char[][] array = new char[16][16];

//		for (int i = 0; i < array.length; i++) {
//			if (i % 2 == 0) {
//				for (int j = 0; j < array.length; j++) {
//					if (j%2==0) {
//						array[i][j]='#';
//					}else if (j%2==1) {
//						array[i][j]=' ';
//					}
//				}
//			}else {
//				for (int j = 0; j < array.length; j++) {
//					if (j%2==0) {
//						array[i][j]=' ';
//					}else if (j%2==1) {
//						array[i][j]='#';
//					}
//				}
//			}
//		}

		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < array.length - 1; j++) {
					if (j % 2 == 0) {
						array[i][j] = '#';
						array[i+1][j + 1] = '#';
					} else if (j % 2 == 1) {
						array[i][j] = ' ';
						array[i][j] = ' ';
					}
				}
			} else {
				for (int j = 0; j < array.length; j++) {
					if (j % 2 == 0) {
						array[i][j] = ' ';
					} else if (j % 2 == 1) {
						array[i][j] = '#';
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
