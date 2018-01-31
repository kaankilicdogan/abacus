package com.kaan.abacus.unittest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.validation.ValidationException;

import org.junit.Test;
import org.springframework.context.annotation.Description;

import com.kaan.abacus.model.AbacusModel;
import com.kaan.abacus.service.imp.AbacusServiceImp;

/**
 * The Class Abacus Business Test.
 * 
 * @author Kaan Kilicdogan
 */
public class AbacusBusinessTests {
	
	@Description("This tests the happy path of the abacus business.")
	@Test()
	public void abacusHappyPathTest() {
		AbacusModel abacusModel = new AbacusModel();
		AbacusServiceImp abacusService = new AbacusServiceImp();
		abacusModel.setAdditionValue(5);
		abacusModel.setThreadsValue("{ooo---oooooo,ooooooooo---,---ooooooooo,---ooooooooo,oo---ooooooo,---ooooooooo}");
		String result = abacusService.add(abacusModel);
		assertThat(result, is("{ooo---oooooo,ooooooooo---,---ooooooooo,---ooooooooo,o---oooooooo,ooooo---oooo}"));
	}
	
	@Description("This tests the zero addition case.")
	@Test()
	public void abacusZeroAdditionTest() {
		AbacusModel abacusModel = new AbacusModel();
		AbacusServiceImp abacusService = new AbacusServiceImp();
		abacusModel.setAdditionValue(0);
		abacusModel.setThreadsValue("{ooo---oooooo,---ooooooooo,---ooooooooo,---ooooooooo,oo---ooooooo,---ooooooooo}");
		String result = abacusService.add(abacusModel);
		assertThat(result, is(abacusModel.getThreadsValue()));
	}
	
	@Description("This tests the empty threads value case.")
	@Test(expected = ValidationException.class)
	public void abacusEmptyThreadsTest() {
		AbacusModel abacusModel = new AbacusModel();
		AbacusServiceImp abacusService = new AbacusServiceImp();
		abacusModel.setAdditionValue(0);
		abacusModel.setThreadsValue("");
		abacusService.add(abacusModel);		
	}
	
	@Description("This tests the null threads value case.")
	@Test(expected = ValidationException.class)
	public void abacusNullThreadsTest() {
		AbacusModel abacusModel = new AbacusModel();
		AbacusServiceImp abacusService = new AbacusServiceImp();
		abacusModel.setAdditionValue(0);
		abacusService.add(abacusModel);		
	}
	
	@Description("This tests the missing one thread value case.")
	@Test(expected = ValidationException.class)
	public void abacusMissingThreadsTest() {
		AbacusModel abacusModel = new AbacusModel();
		AbacusServiceImp abacusService = new AbacusServiceImp();
		abacusModel.setAdditionValue(1);
		abacusModel.setThreadsValue("{ooo---oooooo,---ooooooooo,---ooooooooo,---ooooooooo,oo---ooooooo}");
		abacusService.add(abacusModel);		
	}
	
	@Description("This tests the Worng thread value case.")
	@Test(expected = ValidationException.class)
	public void abacusWrongThreadValueTest() {
		AbacusModel abacusModel = new AbacusModel();
		AbacusServiceImp abacusService = new AbacusServiceImp();
		abacusModel.setAdditionValue(0);
		abacusModel.setThreadsValue("{ooo---oooooo,---ooooooooo,---ooooooooo,---ooooooooo,oo---ooooooo,---oooooooooo}");
		abacusService.add(abacusModel);
	}
}
