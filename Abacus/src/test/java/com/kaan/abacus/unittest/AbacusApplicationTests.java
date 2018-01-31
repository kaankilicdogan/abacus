package com.kaan.abacus.unittest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringRunner;

import com.kaan.abacus.controller.AbacusController;

/**
 * The Class AbacusApplicationTests.
 * @author Kaan Kilicdogan
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AbacusApplicationTests {
	 
 	/** The abacus controller. */
 	@Autowired
	 private AbacusController abacusController;
	 
	 /**
 	 * Tests the Abacus Controller main operation.
 	 */
 	@Description("This tests abacus controller.")
 	@Test
	 public void controllerTest() {
		 String result = abacusController.mainPage(null);
		 assertThat(result, is("main_page"));
	 }
}
