package com.kaan.abacus.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaan.abacus.model.AbacusModel;
import com.kaan.abacus.restcontroller.AbacusRestController;
import com.kaan.abacus.service.AbacusService;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * The Class AbacusRestControllerTests.
 * @author Kaan Kilicdogan
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AbacusRestController.class)
public class AbacusRestControllerTests {

	/** The mvc. */
	@Autowired
    private MockMvc mvc;

    /** The abacus service. */
    @MockBean
    private AbacusService abacusService;
    
    @Description("This tests abacus rest controller.")
    @Test
    public void addTest() throws Exception {
    	AbacusModel abacusModel = new AbacusModel();
    	abacusModel.setAdditionValue(5);
    	abacusModel.setThreadsValue("{ooo---oooooo,ooooooooo---,---ooooooooo,---ooooooooo,oo---ooooooo,---ooooooooo}");
    	given(this.abacusService.add(abacusModel)).willReturn("{ooo---oooooo,ooooooooo---,---ooooooooo,---ooooooooo,o---oooooooo,ooooo---oooo}");
    	
    	byte[] requestJson = toJson(abacusModel);
    	this.mvc.perform(post("/ajax/add").content(requestJson).accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content()
    		      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
    
    @Description("This tests abacus rest controller binding problem test.")
    @Test
    public void addBindingProblemTest() throws Exception {
    	AbacusModel abacusModel = new AbacusModel();
    	abacusModel.setAdditionValue(5);    	
    	given(this.abacusService.add(abacusModel)).willReturn("{ooo---oooooo,ooooooooo---,---ooooooooo,---ooooooooo,o---oooooooo,ooooo---oooo}");
    	
    	byte[] requestJson = toJson(abacusModel);
    	this.mvc.perform(post("/ajax/add").content(requestJson).accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isBadRequest()).andExpect(content()
    		      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
    
    /**
     * To json operation.
     *
     * @param r the object which will convert to JSON
     * @return the byte[] json result
     * @throws Exception the exception
     */
    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}
