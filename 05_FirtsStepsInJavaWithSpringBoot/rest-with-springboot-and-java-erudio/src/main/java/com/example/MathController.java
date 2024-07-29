package com.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.UnsupportedMathOperation;

@RestController
public class MathController {
	
	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();	
	Validations validate = new Validations();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
			          @PathVariable(value = "numberTwo") String numberTwo)
			          throws Exception {
		if(!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperation("Please set a numeric value");
		}
			return validate.convertToDouble(numberOne) + validate.convertToDouble(numberTwo);
	}	
	@RequestMapping(value = "/diff/{numberOne}/{numberTwo}", method=RequestMethod.GET)
			public Double diff(@PathVariable(value = "numberOne") String numberOne, 
					          @PathVariable(value = "numberTwo") String numberTwo)
					          throws Exception {
				if(!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) { 
					throw new UnsupportedMathOperation("Please set a numeric value");
				}
					return validate.convertToDouble(numberOne) - validate.convertToDouble(numberTwo);
			}
	@RequestMapping(value = "/product/{numberOne}/{numberTwo}",	method=RequestMethod.GET)
			public Double product(@PathVariable(value = "numberOne") String numberOne, 
					          @PathVariable(value = "numberTwo") String numberTwo)
					          throws Exception {
				if(!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) { 
					throw new UnsupportedMathOperation("Please set a numeric value");
				}
					return validate.convertToDouble(numberOne) * validate.convertToDouble(numberTwo);
			}
	@RequestMapping(value = "/quotient/{numberOne}/{numberTwo}", method=RequestMethod.GET)
			public Double quotient(@PathVariable(value = "numberOne") String numberOne, 
					          @PathVariable(value = "numberTwo") String numberTwo)
					          throws Exception {
				if(!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) { 
					throw new UnsupportedMathOperation("Please set a numeric value");
				}
					return validate.convertToDouble(numberOne) /  validate.convertToDouble(numberTwo);
			}
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",	method=RequestMethod.GET)
			public Double average(@PathVariable(value = "numberOne") String numberOne, 
					          @PathVariable(value = "numberTwo") String numberTwo)
					          throws Exception {
				if(!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) { 
					throw new UnsupportedMathOperation("Please set a numeric value");
				}
					return (validate.convertToDouble(numberOne) + validate.convertToDouble(numberTwo)) / 2;
			}
	@RequestMapping(value = "/sqrroot/{numberOne}",	method=RequestMethod.GET)
			public Double sqrtoot(@PathVariable(value = "numberOne") String numberOne)
					          throws Exception {
				if(!validate.isNumeric(numberOne)) { 
					throw new UnsupportedMathOperation("Please set a numeric value");
				}
					return Math.sqrt(validate.convertToDouble(numberOne));
			}

}
