package com.hardik.controllers;


import java.security.Principal;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.models.Leave;
import com.hardik.models.UserQuery;
import com.hardik.models.Employee;
import com.hardik.service.DepartmentService;
import com.hardik.service.EmployeeService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/home")
	public String userHome(Model model)
	{	
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String empName=auth.getName();
		Employee employee= employeeService.findByUsername(empName);
		List<Employee> employees= new ArrayList<Employee>();
		employees.add(employee);
		model.addAttribute("userList", employees);
		
		return "userHome.jsp";
	}
	@RequestMapping("/edit")
	public String editUser(Model model)
	{
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String userName= auth.getName();
		Employee employee= employeeService.findByUsername(userName);
		model.addAttribute("userDetail",employee);
		model.addAttribute("departmentList", departmentService.findAllDepartments());
		return "userEdit.jsp";
	}
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String userEdited(@ModelAttribute("employee")Employee employee)
	{
		employeeService.updateEmployeeDetails(employee);	//update Record
		
//		Employee employee1= employeeService.findByEmpId(employee.getEmpId());
//		List<Employee> employees= new ArrayList<Employee>();
//		employees.add(employee1);
//		model.addAttribute("userList", employees);
		return "redirect:/user/home";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")int empId)
	{
		employeeService.deleteEmployee(empId);
		return "account-delete.jsp";
	}
	
	@RequestMapping("/attendance")
	public String attendance(@RequestParam("inTime")String intime,@RequestParam("outTime")String outTime) {
		
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String userName= auth.getName();
		employeeService.attendance(userName, intime, outTime);
		return "redirect:/user/home";		
	}
	
	//--------------------------------------------------------------------------------
	@RequestMapping("/leaves")
	public String Leave(Model model)
	{	
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String empName=auth.getName();
		Employee employee= employeeService.findByUsername(empName);
		List<Leave> leaves=employee.getLeave();
		model.addAttribute("leaves",leaves);
		return "employeeLeaves.jsp";
	}
	@RequestMapping("/applyLeaves")
	public String applyLeave(Model model,Principal principal)
	{	
//		String userName=principal.getName();
//		User user= userService.findByUserName(userName);
//		model.addAttribute("user",user);
		model.addAttribute("leave",new Leave());
		return "LeaveApplicationForm.jsp";
	}
	@RequestMapping(value="/applyLeaves", method=RequestMethod.POST)
	public String applyLeave(@Valid @ModelAttribute("leave")Leave leave,BindingResult bindingResult,Principal principal,Model model)
	{	
		if(bindingResult.hasErrors()){
			model.addAttribute("leave",leave);
			return "LeaveApplicationForm.jsp";
		}
		
		if((leave.getLeaveFrom()==null || leave.getLeaveTo()==null))	//to check dates are not empty
		{
			model.addAttribute("message","Both Dates should Be mensioned , Please try Again!!!");
			model.addAttribute("leave",leave);
			return "LeaveApplicationForm.jsp";
		}
		else if(!(leave.getLeaveFrom().before(leave.getLeaveTo())))	//to check validity of period of dates
		{
			model.addAttribute("message","Dates Are Note valid Please try Again!!!");
			model.addAttribute("leave",leave);
			return "LeaveApplicationForm.jsp";
		}
		System.out.println(leave.getLeaveFrom().before(leave.getLeaveTo()));
			

//		if(bindingResult.hasErrors()){
//			model.addAttribute("leave",leave);
//			return "LeaveApplicationForm.jsp";
//		}
		
		String userName=principal.getName();
		employeeService.addLeave(userName, leave);
		
		return "redirect:leaves";
	}
	//--------------------------------------------------------------------------------
	
	/* for user query 	*/	
		@RequestMapping("/raiseQuery")
		public String raiseQuery(Model model)
		{	
			Authentication auth= SecurityContextHolder.getContext().getAuthentication();
			String empName=auth.getName();
			Employee employee= employeeService.findByUsername(empName);
			List<UserQuery> userQueries=employee.getUserQuery();
			model.addAttribute("userQueries",userQueries);
			model.addAttribute("userQuery", new UserQuery());
			return "queryForm.jsp";
		}

		@RequestMapping(value="/raiseQuery", method=RequestMethod.POST)
		public String SaveRaisedQuery(@Valid @ModelAttribute("userQuery")UserQuery userQuery,BindingResult bindingResult,Principal principal,Model model)
		{	
			if(bindingResult.hasErrors()){
				model.addAttribute("userQuery",userQuery);
				return "queryForm.jsp";
			}
			
			String userName=principal.getName();
			employeeService.addRaisedQuery(userName, userQuery);
			
			return "redirect:raiseQuery";
		}
}
