package kata.stringcalculator;

public class StringCalculator {
	public int calculate(String input) {
		int result = 0;

		if (isEmpty(input))
			return result;

		if (isDelimiterChanged(input)) {
			input = changeDelimiter(input);
		}

		return calculateSum(parseNumberArray(input));
	}

	private String changeDelimiter(String input) {
		String newDelimiter = Character.toString(input.toCharArray()[2]);
		input = input.replace(newDelimiter, ",").substring(4);
		return input;
	}

	private String[] parseNumberArray(String input) {
		return input.replaceAll("\n", ",").split(",");
	}

	private int calculateSum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			int parsedNumber = Integer.parseInt(number);
			if (isNegativeNumber(parsedNumber)) {
				throw new NegativesNotAllowed(number);
			}
			sum += parsedNumber;
		}
		return sum;
	}

	private boolean isNegativeNumber(int parsedNumber) {
		return parsedNumber < 0;
	}

	private boolean isEmpty(String input) {
		return input.equals("");
	}

	private boolean isDelimiterChanged(String input) {
		return input.startsWith("/");
	}

	public class NegativesNotAllowed extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public NegativesNotAllowed(String message) {
			super(message);
		}
	}
}
