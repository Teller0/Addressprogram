import static org.junit.Assert.*;

import org.junit.Test;


public class TelephonValidatorTest {

	@Test
	public void testIsNumber() {
		TelephonValidator validator = new TelephonValidator();
		assertTrue(validator.isNumber('0'));
		assertFalse(validator.isNumber('o'));
	}

	@Test
	public void testValidate() {
		TelephonValidator validator = new TelephonValidator();
		assertTrue(validator.validate("1232345"));
		assertFalse(validator.validate("2345wer3d"));
		assertTrue(validator.validate("+42323434"));
		assertFalse(validator.validate("22+42323434"));
	}

}
