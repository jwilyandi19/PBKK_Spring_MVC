package com.jwilyandi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController 
{
	@RequestMapping("/")
	public String showForm() 
	{
		return "index";
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
	
	@RequestMapping("/result")
	public String processForm(HttpServletRequest request,Model model) 
	{
		String num1req = request.getParameter("num1");
		String num2req = request.getParameter("num2");
		String operation = request.getParameter("operation");
		
		int num1 = Integer.parseInt(num1req);
		int num2 = Integer.parseInt(num2req);
		int result = calc(num1, num2, operation);
		Calculator calculator = new Calculator();
		calculator.setNum1(num1);
		calculator.setNum2(num2);
		calculator.setOperation(operation);
		
		model.addAttribute("num1", calculator.getNum1());
		model.addAttribute("num2", calculator.getNum2());
		model.addAttribute("operation", calculator.getOperation());
		model.addAttribute("result", result);
		return "result";
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
