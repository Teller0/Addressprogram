package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import validation.NameValidator;

public class NameValidatorTest {

	private NameValidator validator;

	@Before
	public void setUp() throws Exception {
		validator = new NameValidator();
	}

	@Test
	public void testValidate() {
		assertFalse(validator.validate(""));
		assertTrue(validator.validate("2wer"));
		assertFalse(validator.validate(null));
	}

}
