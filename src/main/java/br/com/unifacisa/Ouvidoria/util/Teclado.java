package br.com.unifacisa.Ouvidoria.util;

import java.util.Scanner;

public abstract class Teclado  {

	static Scanner sc = new Scanner(System.in);
	static Scanner si = new Scanner(System.in);
	
	public Integer inteiro() {
		int a = 0;
		try {
			a = Integer.parseInt(null, sc.nextInt());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}
	
	
	public static String texto() {
		return sc.nextLine();
		
	}
	
	public static int inte() {
		return si.nextInt();
	}
	
	
	
	public static void FecharScanner() {
		sc.close();
		si.close();
	}
	
	
	}

