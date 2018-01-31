package com.kaan.abacus.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.kaan.abacus.model.AbacusModel;
import com.kaan.abacus.service.AbacusService;
import com.kaan.abacus.validator.AbacusValidator;

/**
 * The Class AbacusServiceImp.
 * 
 * @author Kaan Kilicdogan
 */
@Service
public class AbacusServiceImp implements AbacusService {

	/* (non-Javadoc)
	 * @see com.kaan.abacus.service.AbacusService#calculate(java.lang.String, int)
	 */
	@Override
	public String add(AbacusModel abacusModel) {
		if(abacusModel.getThreadsValue() == null || abacusModel.getThreadsValue().isEmpty()) {
			throw new ValidationException("Thread value is empty.");
		}
		String tempThreadsValue = abacusModel.getThreadsValue().substring(1, abacusModel.getThreadsValue().length()-1);
		
		List<String> threadList = new ArrayList<>(Arrays.asList(tempThreadsValue.split(",")));
		if(threadList.size() == 6) {
			for(String value : threadList) {				
				if(!AbacusValidator.isValid(value)) {
					// this part is not valid
					throw new ValidationException("Thread value is not valid. Value : " + value);
				}				
			}
		} else {
			// input is invalid.
			throw new ValidationException("Thread input has to 6 row. Input has : " + threadList.size());
		}
		
		// I dont make ABACUS as Service. Because I want to keep that file as Top Coder says.
		Abacus abacusCalculator = new Abacus();
		String[] result = abacusCalculator.add(threadList.toArray(new String[threadList.size()]), abacusModel.getAdditionValue());
		StringBuilder resultStringBuilder = new StringBuilder();
		resultStringBuilder.append('{');
		for(int i = 0; i< result.length; i++) {
			if (i > 0) {
				resultStringBuilder.append(',');
			}
			resultStringBuilder.append(result[i]);			
		}
		resultStringBuilder.append('}');
		
		return resultStringBuilder.toString();
	}

}
