package kata.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testCalculator() {
		assertEquals(0, calculate(""));
		assertEquals(0, calculate("0"));
		assertEquals(0, calculate("0,0"));
		assertEquals(1, calculate("1"));
		assertEquals(5, calculate("5"));
		assertEquals(2, calculate("1,1"));
		assertEquals(4, calculate("4"));
		assertEquals(6, calculate("4,2"));
		assertEquals(12, calculate("4,4,4"));
	}

	private int calculate(String input) {
		int result = 0;

		if (isEmpty(input))
			return result;

		return calculateSum(input.split(","));
	}

	private int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}

	private boolean isEmpty(String input) {
		return input.equals("");
	}
}
