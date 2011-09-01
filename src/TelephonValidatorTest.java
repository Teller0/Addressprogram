import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TelephonValidatorTest {

	private TelephonValidator validator;

	@Before
	private void setUp() {
		validator = new TelephonValidator();
	}
	
	@Test
	public void testIsNumber() {
		assertTrue(validator.isNumber('0'));
		assertFalse(validator.isNumber('o'));
	}

	@Test
	public void testValidate() {
		assertTrue(validator.validate("1232345"));
		assertFalse(validator.validate("2345wer3d"));
		assertTrue(validator.validate("+42323434"));
		assertFalse(validator.validate("22+42323434"));
	}

}
