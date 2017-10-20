package etsisi.vyv2017.lab2junit_EjemploCalculadora;

public class CalculadoraMain {

	public static void main(String[] args) {
		Calculadora c = new Calculadora();
		try {
			c.operacion("(2+1)");
		} catch (CalculadoraExpresionException e) {
			e.printStackTrace();
		}
	}

}
