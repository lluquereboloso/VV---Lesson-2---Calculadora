package etsisi.vyv2017.lab2junit_EjemploCalculadora;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculadora {

	public int sumar(int i, int j) {
		return i+j;
	}

	public int restar(int i, int j) {
		return i-j;
	}

	public int multiplicar(int i, int j) {
		return i*j;
	}

	public int dividir(int i, int j) {
		return i/j;
	}

	public String[] operacion(String s) throws CalculadoraExpresionException {
		String[] result = new String[3];
		String op1, op2, operador = null;
		Pattern patron;
		Matcher match;
		patron = Pattern.compile("[\\d]+");
		match = patron.matcher(s);
		if (match.find()) {
				op1 = match.group();
				match.find();
				op2 = match.group();
		} else {
			throw new CalculadoraExpresionException("Error no se encuentran los operandos para la expresion " + s);
		}
		patron = Pattern.compile("[\\+\\-\\*\\\\]");
		match = patron.matcher(s);
		if (match.find()) {
			operador = match.group();
		} else {
			throw new CalculadoraExpresionException("Error no se encuentra operador en la expresion " + s);
		}
		System.out.println(op1 + " " + op2 + " " + operador);
		result[0] = op1;
		result[1] = op2;
		result[2] = operador;
		return result;
	}

	public String ejecutar(String[] datos) {
		String resultado;
		int op1 = Integer.valueOf(datos[0]);
		int op2 = Integer.valueOf(datos[1]);
		char operador = datos[2].charAt(0);
		switch (operador) {
		case '+':
			resultado = String.valueOf(this.sumar(op1, op2)); 
			break;
		case '-':
			resultado = String.valueOf(this.restar(op1, op2)); 
			break;
		case '*':
			resultado = String.valueOf(this.multiplicar(op1, op2)); 
			break;
		case '\\':
			resultado = String.valueOf(this.dividir(op1, op2)); 
			break;
		default:
			resultado = null;
		}
		return resultado;
	}
}
