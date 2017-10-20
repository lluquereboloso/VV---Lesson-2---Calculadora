package etsisi.vyv2017.lab2junit_EjemploCalculadora;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	
	Calculadora c;
	
	@Before
	public void setUp()  {
		c = new Calculadora();
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void sumar() {		
		assertEquals(10, c.sumar(6, 4));
	}

	@Test
	public void restar() {		
		assertEquals(2, c.restar(6, 4));
	}

	@Test
	public void multiplicar() {		
		assertEquals(24, c.multiplicar(6, 4));
	}

	@Test
	public void dividir() {		
		assertEquals(1, c.dividir(6, 4));
	}

	@Test(expected = ArithmeticException.class)
	public void dividirPorCero() {		
		c.dividir(5, 0);
	}

	@Test
	public void expresionSencilla() {		
		String[] array = { "2", "1", "+" };
		try {
			assertArrayEquals((array), c.operacion("(2+1)"));
		} catch (CalculadoraExpresionException e) {
			fail("Salta excepcion - No deberia haber fallado");
		}
	}

	@Test
	public void expresionConEspacios() {		
		String[] array = { "15", "2", "*" };
		try {
			assertArrayEquals((array), c.operacion("( 15 * 2)"));
		} catch (CalculadoraExpresionException e) {
			fail("Salta excepcion - No deberia haber fallado");
		}
	}

	@Test
	public void expresionErronea() {		
		try {
			c.operacion("( ?1w5 a 2)");
			fail("No salta excepcion");
		} catch (CalculadoraExpresionException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void calculoExpresionSencilla() {		
		try {
			assertEquals("3", c.ejecutar(c.operacion("2+1")));
		} catch (CalculadoraExpresionException e) {
			fail("Salta excepcion - No deberia haber fallado");
		}
	}

}
