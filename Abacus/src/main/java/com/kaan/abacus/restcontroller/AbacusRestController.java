package com.kaan.abacus.restcontroller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaan.abacus.ajax.result.AjaxResult;
import com.kaan.abacus.model.AbacusModel;
import com.kaan.abacus.service.AbacusService;

/**
 * The Class AbacusRestController.
 */
@RestController
@RequestMapping("/ajax")
public class AbacusRestController {

	/** The abacus service. */
	@Autowired
	private AbacusService abacusService;

	/**
	 * Adds the given value to initial threads.
	 *
	 * @param abacus
	 *            the abacus
	 * @param bindingResult
	 *            the binding result
	 * @param model
	 *            the model
	 * @return the response entity
	 */
	@PostMapping(value = "add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<AjaxResult> add(@RequestBody @Valid AbacusModel abacus, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new AjaxResult(bindingResult));
		}

		try {
			String result = this.abacusService.add(abacus);
			return new ResponseEntity<>(new AjaxResult(result), HttpStatus.OK);
		} catch (ValidationException ex) {
			// catch validation exceptions and create error result
			return ResponseEntity.badRequest().body(new AjaxResult(ex));
		}

	}
}
