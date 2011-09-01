package validation;

public class NameValidator implements IValidator{
	public boolean validate(String input){
		return true;
	}

	@Override
	public String getValidMessage() {
		return "valid name";
	}

	@Override
	public String getInvalidMessage() {
		return "invalid name";
	}
}
