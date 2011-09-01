package validation;

public class NameValidator implements IValidator{
	public boolean validate(String input){
		return input != null && input.length() > 0;
	}

	@Override
	public String getInvalidMessage() {
		return "invalid name";
	}
}
