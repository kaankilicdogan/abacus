package com.kaan.abacus.service.imp;

/**
 * The Class Abacus which Top Coder request.
 */
public class Abacus {

	/**
	 * Adds the value to given thread value.
	 *
	 * @param original the original thread value
	 * @param val the val that will be added to thread value
	 * @return the string[] new thread value
	 */
	public String[] add(String[]original, int val) {
    	if(val == 0) {
    		// No need to calculate
            return original;    
        }
    	
        int originalVal = 0;
        int digitMultiplier =1;
        for(int index =5; index >= 0; index--) {
            originalVal += this.getIntegerValueOfString(original[index]) * digitMultiplier;
            digitMultiplier = digitMultiplier * 10;
        }
        
        originalVal += val;
        
        return this.getResultArrayFromInteger(originalVal);
    }
    
    /**
     * Gets the integer value of string.
     *
     * @param value the value
     * @return the integer value of string
     */
    private int getIntegerValueOfString(String value) {
    	return 9 - value.indexOf("---");
    }
    
    /**
     * Gets the result array from integer.
     *
     * @param value the value
     * @return the result array from integer
     */
    private String[] getResultArrayFromInteger(int value) {
        String[] result = new String[6];
        int tempValue = value;
        for(int index =5; index >= 0; index--) {
           int digitValue = tempValue % 10;
           tempValue = tempValue / 10;
           result[index] = this.createStringValue(digitValue); 
        }
        
        return result;
    }
    
    /**
     * Creates the string value.
     *
     * @param digit the digit
     * @return the string
     */
    private String createStringValue(int digit) {
    	StringBuilder result = new StringBuilder();
        for (int i = 0; i< (9 - digit); i++) {
        	result.append("o");    
        }
        
        result.append("---");
        for (int i = 0; i< digit; i++) {
        	result.append("o");    
        }
        
        return result.toString();
    }
}
