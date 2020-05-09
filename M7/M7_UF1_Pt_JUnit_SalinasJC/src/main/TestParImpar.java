package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestParImpar {

	@Test
	public void test() {
		Main test = new Main();
		int res = test.parImpar(10);
		assertEquals(0, res);
	}

}
