package com.kaan.abacus.validator;

/**
 * The Class AbacusValidator.
 * 
 * @author Kaan Kilicdogan
 */
public final class AbacusValidator {

	/** The Constant DASH_STRING. */
	private static final String DASH_STRING = "---";
	
	/** The Constant START_WITH_DASH regular expression. */
	private static final String START_WITH_DASH = "[-]{3}[o]{9}";
	
	/** The Constant END_WITH_DASH regular expression. */
	private static final String END_WITH_DASH = "[o]{9}[-]{3}";
	
	/**
	 * Instantiates a new abacus validator.
	 */
	private AbacusValidator() {
		throw new IllegalStateException(" Abacus Validator class");
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param threadValue the thread value
	 * @return true, if is valid
	 */
	public static boolean isValid(String threadValue) {
		// get dash index.
		int dashIndex = threadValue.indexOf(DASH_STRING);
		
		if(dashIndex == -1) {
			// there is no dash in string.
			return false;
		} else if (dashIndex == 0) {
			// input begins with dash
			return threadValue.matches(START_WITH_DASH) ? true : false;
		} else if (dashIndex == 9) {
			// input ends with dash
			return threadValue.matches(END_WITH_DASH) ? true : false;
		} else {
			// dash in somewhere between first and last letter
			String regEx = "[o]{" + dashIndex + "}[-]{3}[o]{" + (9-dashIndex) + "}";
			return threadValue.matches(regEx) ? true : false;
		}
	}
}
