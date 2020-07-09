package com.hardik.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hardik.models.Department;
import com.hardik.models.Employee;
import com.hardik.service.DepartmentService;
import com.hardik.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
//	@Autowired
//	private EmployeeValidator employeeValidator ; 

	@RequestMapping({"/","/login"})
	public String login(){
		return "login.jsp";
	}
	@RequestMapping("/logout-success")
	public String logout(){
		return "logout.jsp";
	}
	@GetMapping("/registration")
	public String register(Model m)
	{
//		m.addAttribute("command", new Employee());	//command is used to inform that from data are of obj type 
		m.addAttribute("employee", new Employee());
//		System.out.println("_-------------"+departmentService.findAllDepartments());
		m.addAttribute("departmentList", departmentService.findAllDepartments());
		
		return "registration.jsp";
	}
	
	@PostMapping("/registration")
	public String save(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult,
			@ModelAttribute("department") Department department,Model m)
	{
		System.out.println("Professing form...");
		String empName = employee.getUsername();
		System.out.println("NAme is:"+empName);	
		System.out.println("department name+"+department);
				
		if(bindingResult.hasErrors()){
			
			m.addAttribute("employee", employee);	//command is used to inform that from data are of obj type 
			m.addAttribute("departmentList", departmentService.findAllDepartments());
			
			return "registration.jsp";
		}
		
		if ((employeeService.findByUsername(empName))!=null)
		{
			return "registrationError.jsp";
		}
		
		employeeService.Save(employee);
		return "registrationSuccess.jsp";
	}
	
//	@ModelAttribute
//	public void headerMessage(Model model){
//		
//		
//		List<String> departmentList = new ArrayList<>();
//		departmentList.add("Human Resource Management");
//		departmentList.add("Research and Development");
//		departmentList.add("Production");
//		departmentList.add("Marketing");
//		departmentList.add("Accounting and Finance");		
//		
//		model.addAttribute("departmentList", departmentList);
//		
//	}
	
}
