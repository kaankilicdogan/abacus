package com.kaan.abacus.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class AbacusModel.
 * 
 * @author Kaan Kilicdogan
 */
public class AbacusModel {
	
	/** The 6 row threads value. */
	@NotEmpty
	@Size(min=79, max=79)
	private String threadsValue;
	
	/** The addition value to add 6 row threads value. */
	@NotNull
	@Min(0)
	@Max(999999)
	private int additionValue;

	/**
	 * Gets the threads value.
	 *
	 * @return the threads value
	 */
	public String getThreadsValue() {
		return threadsValue;
	}

	/**
	 * Sets the threads value.
	 *
	 * @param threadsValue the new threads value
	 */
	public void setThreadsValue(String threadsValue) {
		this.threadsValue = threadsValue;
	}

	/**
	 * Gets the addition value.
	 *
	 * @return the addition value
	 */
	public int getAdditionValue() {
		return additionValue;
	}

	/**
	 * Sets the addition value.
	 *
	 * @param additionValue the new addition value
	 */
	public void setAdditionValue(int additionValue) {
		this.additionValue = additionValue;
	}

}
