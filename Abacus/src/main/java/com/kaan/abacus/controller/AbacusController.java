package com.kaan.abacus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class AbacusController.
 * 
 * @author Kaan Kilicdogan
 */
@Controller
public class AbacusController {

	/** The Constant MAIN_PAGE. */
	private static final String MAIN_PAGE = "main_page";
	
	/**
	 * Main page.
	 *
	 * @param model the model object.
	 * @return the main page jsp name.
	 */
	@RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String mainPage(Model model) {
        return MAIN_PAGE;
    }
}
