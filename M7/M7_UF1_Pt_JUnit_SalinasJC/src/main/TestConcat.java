package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConcat {

	@Test
	public void testConcat() {
		Main test = new Main();
		String res = test.concatStrings("Juan", " Carlos");
		assertEquals("Juan Carlos", res);
	}

}
