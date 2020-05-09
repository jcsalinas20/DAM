package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSumar {
	
	@Test(expected = numeroNegativoException.class)
	public void testException() throws numeroNegativoException {
		Main test = new Main();
		int res = test.sumar(6, -14);
		assertEquals(20, res);
	}
	
	@Test
	public void test() throws numeroNegativoException {
		Main test = new Main();
		int res = test.sumar(6, 14);
		assertEquals(20, res);
	}
	

}
 