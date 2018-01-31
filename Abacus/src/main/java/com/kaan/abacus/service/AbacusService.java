package com.kaan.abacus.service;

import com.kaan.abacus.model.AbacusModel;

/**
 * The Interface AbacusService.
 * 
 * @author Kaan Kilicdogan
 */
public interface AbacusService {

	/**
	 * Add additional value to threadsValue.
	 *
	 * @param abacusModel the abacus model object
	 * @return the new threads value.
	 */
	String add(AbacusModel abacusModel);
}
