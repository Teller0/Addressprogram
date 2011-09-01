package validation;

public interface IValidator {

	boolean validate(String input);

	String getInvalidMessage();

}