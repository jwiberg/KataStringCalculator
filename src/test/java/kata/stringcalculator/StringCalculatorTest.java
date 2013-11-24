package kata.stringcalculator;

import static org.junit.Assert.assertEquals;
import kata.stringcalculator.StringCalculator.NegativesNotAllowed;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@Before
	public void before() {
		this.calculator = new StringCalculator();
	}

	@Test
	public void testCalculator() {
		assertEquals(0, calculator.calculate(""));
		assertEquals(0, calculator.calculate("0"));
		assertEquals(0, calculator.calculate("0,0"));
		assertEquals(1, calculator.calculate("1"));
		assertEquals(5, calculator.calculate("5"));
		assertEquals(2, calculator.calculate("1,1"));
		assertEquals(4, calculator.calculate("4"));
		assertEquals(6, calculator.calculate("4,2"));
		assertEquals(12, calculator.calculate("4,4,4"));
		assertEquals(8, calculator.calculate("4\n4"));
		assertEquals(12, calculator.calculate("4,4\n4"));
		assertEquals(3, calculator.calculate("//;\n1;2"));
	}

	@Test(expected = NegativesNotAllowed.class)
	public void negativesAreNotAllowed() {
		calculator.calculate("-1,2,2");
	}
}
