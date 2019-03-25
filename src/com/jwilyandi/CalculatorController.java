package com.jwilyandi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class CalculatorController 
{
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelAndView Calculator() {
		return new ModelAndView("form","command",new Calculator());
	}
	
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("SpringWeb")Calculator
			calculator, ModelMap model) 
	{
		
		int num1 = calculator.getNum1();
		int num2 = calculator.getNum2();
		String operation = calculator.getOperation();
		int result = calc(num1, num2, operation);

		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("operation", operation);
		model.addAttribute("result", result);
		return "result";
	}
	
	public int calc(int num1,int num2,String operation) 
	{
		if(operation.equals("+"))
		{
			return num1+num2;
		}
		if(operation.equals("-"))
		{
			return num1-num2;
		}
		if(operation.equals("*"))
		{
			return num1*num2;
		}
		if(operation.equals("/"))
		{
			return num1/num2;
		}
		return 0;
	}
	
	@ModelAttribute("operationList")
	public HashMap<String,String> getOperationList() 
	{
		HashMap<String,String> operationsList = 
				new HashMap<String,String>();
		operationsList.put("Pertambahan", "+");
		operationsList.put("Pengurangan", "-");
		operationsList.put("Perkalian"  , "*");
		operationsList.put("Pembagian"  , "/");
		return operationsList;
		
	}
}
