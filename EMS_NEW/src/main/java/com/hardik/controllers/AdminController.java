package com.hardik.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hardik.models.Employee;
import com.hardik.models.UserQuery;
import com.hardik.repository.LeaveRepository;
import com.hardik.service.EmployeeService;
import com.hardik.service.LeaveService;
import com.hardik.service.UserQueryService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final String DATE_PATTERN = "yyyy/MM/dd";
	
//	@Autowired
//	private AdminService adminService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private UserQueryService userQueryService;
	
	@RequestMapping("/home")
	public String home(Model m,Pageable pageable)
	{
		List<Employee> employees=employeeService.findAll(pageable);
		int totalRecords=(int) employeeService.findAll().stream().count();
		System.out.println("Total Record:"+totalRecords);
		m.addAttribute("totalRecords",totalRecords);
		m.addAttribute("empList", employees);
		return "adminHome.jsp";
	}
	
	 @GetMapping("/employees")
	 public String getStudents(	@RequestParam(required = false)
                                @DateTimeFormat(pattern = DATE_PATTERN) Date fromDate,
                                @RequestParam(required = false)
                                @DateTimeFormat(pattern = DATE_PATTERN) Date toDate,
                                @RequestParam(required = false) String name,
                                Pageable pageable,Model m){
        List<Employee> employees=employeeService.getEmployeeBetweenDates(fromDate, toDate, name, pageable);
        m.addAttribute("empList", employees);
        m.addAttribute("totalRecords",0);
		return "adminHome.jsp";
    }
	
	@RequestMapping("/edit")
	public String editUser(Model model, @RequestParam("empId")int empId)
	{
		Employee employee= employeeService.findById(empId);			
		List<Employee> userList= new ArrayList<Employee>();
		userList.add(employee);
		model.addAttribute("empList", userList);
		return "adminEdit.jsp";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String userEdited(@ModelAttribute("employee")Employee employee)
	{
		employeeService.updateEmployeeDetails(employee);
		return "redirect:/admin/home";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")int id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/admin/home";
	}
	
//	To implement search Functionality
	@RequestMapping("/search")
	public String search(@RequestParam String keyword,Model m) {
	    List<Employee> result = employeeService.search(keyword);
//	    ModelAndView mav = new ModelAndView("adminHome.jsp");
	    m.addAttribute("empList", result);
	    m.addAttribute("totalRecords",0);
	 
	    return "adminHome.jsp";    
	}
	
	@RequestMapping("/sortBy")
	public String sortByProperty(@RequestParam String property,Model m) {
		List<Employee> employees = employeeService.sortByProperty(property);
		m.addAttribute("empList", employees);
		m.addAttribute("totalRecords",0);
		return "adminHome.jsp";
	}
	
	@RequestMapping("/payroll")
	public String payroll(Model m) {
		
		List<Employee> employees=employeeService.findAll();
		m.addAttribute("empList", employees);					
		return "salaryPage.jsp";
	}
	
	@RequestMapping("/sendMoney")
	public String payroll(@RequestParam("empId")int empId,@RequestParam("salary")double salary,Model m) {
		
//		System.out.println("id->:"+empId+"\t\tsalry:- >"+salary);
		employeeService.sendAmount(empId, salary);
		List<Employee> employees=employeeService.findAll();
		List<Employee> newEmp = employees.stream().filter(emp->(emp.getWorkingDaysOfThisMonth()!=0.0)).collect(Collectors.toList());
		System.out.println("new data->:"+newEmp);
		m.addAttribute("empList", newEmp);					
		return "salaryPage.jsp";
	}
	
	//----------------------------------------------------------------------------------
	@RequestMapping("/allLeaveRequest")
	public String manageLeaves(Model model)
	{
		int status=0;	//for requested Leave application
		model.addAttribute("leaves",leaveService.findAllLeaves(status));
		return "requestedLeaves.jsp";
	}
	@RequestMapping("/grantLeave")
	public String grantLeave(@RequestParam("leaveId")int leaveId)
	{
		leaveService.grantLeave(leaveId);
		return "redirect:allLeaveRequest";
		
	}
	@RequestMapping("/rejectLeave")
	public String rejectLeave(@RequestParam("leaveId")int leaveId)
	{
		leaveService.rejectLeave(leaveId);
		return "redirect:allLeaveRequest";
		
	}
	//----------------------------------------------------------------------------------
	
	/* for responding queries*/
	@RequestMapping("/allUserQueries")
	public String AllUserQueries(Model model)
	{
		int status=0;	//for Generated Queries
		model.addAttribute("query",userQueryService.findAllUserQueries(status));		
		return "adminAllQuery.jsp";
	}
	
	@RequestMapping(value ="/queryReply/{queryId}" )
	public String submitQueryReply(Model model,@PathVariable("queryId")int queryId)
	{
		int status=0;	//for Generated Queries
		System.out.println("--------------->>>>>"+queryId);
		model.addAttribute("userQuery", userQueryService.findByQueryId(queryId));
		System.out.println("---------"+userQueryService.findByQueryId(queryId));
		model.addAttribute("query",userQueryService.findAllUserQueries(status));
		return "adminQueryReply.jsp";
	}
	
	@RequestMapping(value = "/saveQueryReply", method = RequestMethod.POST)
	public String saveQueryReply(@Valid @ModelAttribute("userQuery") UserQuery userQuery, BindingResult bindingResult,
			Principal principal, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userQuery", userQuery);
			return "adminQueryReply.jsp";
		}

		userQueryService.GiveQueryReply(userQuery);
		return "redirect:allUserQueries";
	}
}
