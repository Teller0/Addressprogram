package validation;

public class TelephonValidator implements IValidator {
	public boolean isNumber(char input) {
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (int k = 0; k < 10; k++) {
			if (numbers[k] == input) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean validate(String input) {
		if (input == null || input.length() == 0) {
			return false;
		}
		int start = 0;
		if (input.startsWith("+")) {
			start++;
		}
		for (int k = start; k < input.length(); k++) {
			if (!isNumber(input.charAt(k))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getInvalidMessage() {
		return "invalid phonenumber";
	}
}
