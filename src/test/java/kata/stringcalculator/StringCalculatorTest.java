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
		assertEquals(2, calculate("1,1"));
		assertEquals(4, calculate("4"));
		assertEquals(8, calculate("4,4"));
	}

	private int calculate(String input) {
		int result = 0;
		if (isEmptyOrZero(input)) {
			result = 0;
		} else {
			String[] numbers = input.split(",");
			if (numbers.length == 1) {
				result = Integer.parseInt(numbers[0]);
			} else {
				result = Integer.parseInt(numbers[0])
						+ Integer.parseInt(numbers[1]);
			}
		}
		return result;
	}

	private boolean isEmptyOrZero(String input) {
		return input.equals("") || input.equals("0") || input.equals("0,0");
	}
}
