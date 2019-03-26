package com.jwilyandi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class CalculatorController 
{
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
	@RequestMapping(value="/calculator", method = RequestMethod.GET)
	public ModelAndView showCalculator() {
		return new ModelAndView("calculator","calculator",new Calculator());
	}
	
	@RequestMapping(value="/addcalculator", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("SpringWeb")Calculator
			calculator, BindingResult result, ModelMap model) 
	{
		
		int num1 = calculator.getNum1();
		int num2 = calculator.getNum2();
		String operation = calculator.getOperation();
		int res = calc(num1, num2, operation);

		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("operation", operation);
		model.addAttribute("resultcalc", res);
		return "result";
	}
	
	public int calc(int num1,int num2,String operation) 
	{
		if(operation.equals("Pertambahan"))
		{
			return num1+num2;
		}
		if(operation.equals("Pengurangan"))
		{
			return num1-num2;
		}
		if(operation.equals("Perkalian"))
		{
			return num1*num2;
		}
		if(operation.equals("Pembagian"))
		{
			return num1/num2;
		}
		return num1%num2;
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
