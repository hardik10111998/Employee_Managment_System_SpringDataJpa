package com.hardik.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.hardik.email.EmailSendService;
import com.hardik.models.Employee;
import com.hardik.models.Leave;
import com.hardik.models.UserQuery;
import com.hardik.repository.EmployeeRepository;
import com.hardik.repository.LeaveRepository;
import com.hardik.repository.UserQueryRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

//	@Autowired
//	BCryptPasswordEncoder encoder;
	
	@Autowired
	private EmailSendService emailSendService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LeaveRepository leaveRepository;
	
	@Autowired
	private UserQueryRepository userQueryRepository;

	@Override
	public void Save(Employee employee) {		
		
//		employee.setPassword(encoder.encode(employee.getPassword()));
		employeeRepository.save(employee);	
		
//		send email for successful registration
		emailSendService.sendPreConfiguredMail("Employee With following details was registered themselves \n\n"+employee);
	}
	
	@Override
	public void deleteEmployee(int empId) {
		
		employeeRepository.deleteById(empId);		
	}
	
	@Override
	public void updateEmployeeDetails(Employee employee) {
		
		Employee oldEmployee = employeeRepository.findById(employee.getId()).get();
		oldEmployee.setActive(employee.getActive());
		oldEmployee.setAge(employee.getAge());		
		oldEmployee.setEmail(employee.getEmail());
		oldEmployee.setPassword(employee.getPassword());
//		oldEmployee.setPassword(encoder.encode(employee.getPassword()));
		oldEmployee.setRoles(employee.getRoles());
		oldEmployee.setSalary(employee.getSalary());
//		oldEmployee.setUsername(employee.getUsername());
//		oldEmployee.setDepartment(employee.getDepartment());
		oldEmployee.setWorkingDaysOfThisMonth(employee.getWorkingDaysOfThisMonth());
		
		employeeRepository.save(oldEmployee);
		
//		employeeRepository.updateEmployeeDetail(employee.getUsername(), employee.getActive(), employee.getRoles(), employee.getPassword(), employee.getId());
	}
	
	@Override
	public Employee findByUsername(String empName) {
	
		return employeeRepository.findByUsername(empName);
	}
	
	@Override
	public Employee findById(int empId) {
		
		return employeeRepository.findById(empId).get();
	}
	
	@Override
	public List<Employee> findAll(Pageable pageable) {	
		
		int pageNo=pageable.getPageNumber()==0?0:pageable.getPageNumber();
//		int pagesize = pageable.getPageSize()==0?3:pageable.getPageSize();
		
		return employeeRepository.findAll(PageRequest.of(pageNo, 4 , Sort.by("id").descending())).getContent();
		
//		Sort descOrderById = Sort.by("id").descending();
//		return employeeRepository.findAll(descOrderById);
	}
	
	@Override
	public List<Employee> findAll() {		
		return employeeRepository.findAll();
	}
	
	//to search by given keyword
	@Override
	public List<Employee> search(String keyword) {
		
		return employeeRepository.search(keyword);
	}
	
	//to sort by property
	@Override
	public List<Employee> sortByProperty(String property) {
		
		//Sort descSortOrder = Sort.by(property).descending(); 
		Sort sortOrder = Sort.by(property); 		 
		List<Employee> list = employeeRepository.findAll(sortOrder);		
		//list.stream().forEach(System.out::println);		
		return list;
	}
	
	
	//to generate dynamic query to find emp according to given date and order by username (desc) order by id(ASC)
	@Override
	public List<Employee> getEmployeeBetweenDates(Date fromDate, Date toDate, String name, Pageable pageable) {
		
		 List<Employee> employees = employeeRepository.findAll((Specification<Employee>) (root, criteriaQuery, criteriaBuilder) -> {
			 
	            Predicate p = criteriaBuilder.conjunction();
	            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
	            	
	                p = criteriaBuilder.and(p, criteriaBuilder.between(root.get("dateOfJoining"), fromDate, toDate));
	            }
	            if (!StringUtils.isEmpty(name)) {
	            	
	                p = criteriaBuilder.and(p, criteriaBuilder.like(root.get("username"), "%" + name + "%"));
	            }
	            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("username")), criteriaBuilder.asc(root.get("id")));
	            return p;
	            
	        }, pageable).getContent();
		 
	        return employees;
	}

	@Override
	public void attendance(String userName,String inTime, String outTime) {
		
		System.out.println("inTime:"+inTime+"\noutTime:"+outTime);		
		LocalTime time1=LocalTime.parse(inTime);	
		LocalTime time2=LocalTime.parse(outTime);			
		Duration gap = Duration.between(time1, time2);
//	    System.out.println("gap between InTime And OutTime is a :-> "+gap);
	    
	    Employee emp = employeeRepository.findByUsername(userName);
	    double oldWorkingHour=emp.getWorkingDaysOfThisMonth();
	    
	    switch (gap.compareTo(Duration.ofHours(4))) {	    
		case 0:		//equals to 4 hour
			System.out.println("Todays Working hour are:-> 4");
			emp.setWorkingDaysOfThisMonth(oldWorkingHour+0.5);			
			break;
		case 1:		// greater than 4 hour	
			if(gap.equals(Duration.ofHours(9))) {
				System.out.println("Todays Working hour are:-> 9");
				emp.setWorkingDaysOfThisMonth(oldWorkingHour+1);
			}
			else {
				System.out.println("Todays Working hour are:-> less than 9 and greater than 4");
				emp.setWorkingDaysOfThisMonth(oldWorkingHour+0.5);
			}
			break;
		case -1:	// less than 4 hour
			System.out.println("Todays Working hour are:->less than 4 ,sorry your day will not be counted ");
			break;

		default:
			break;
		}	
	   
	    System.out.println("saving the Working Hours-----------------");
	    employeeRepository.save(emp);
		
	}

	@Override
	public void sendAmount(int empId, double salary) {	
		
		Employee emp = employeeRepository.findById(empId).get();
		System.out.println("Amount :"+salary+" is send succesfully to Employee with id:"+empId+" and name:"+emp.getUsername());
		emp.setWorkingDaysOfThisMonth(0);
		employeeRepository.save(emp);
		
	}
	
	// Employees Requested Leave are stored 	
	@Override
	public void addLeave(String userName,Leave leave) {
		
		Employee employee=employeeRepository.findByUsername(userName);
		leave.setEmployee(employee);	
		leaveRepository.save(leave);
		
		List<Leave> empLeaves= employee.getLeave();
		empLeaves.add(leave);
		employeeRepository.save(employee);
		
	}

	@Override
	public void addRaisedQuery(String userName, UserQuery userQuery) {
		
		Employee employee=employeeRepository.findByUsername(userName);
		userQuery.setEmployee(employee);	
		userQuery.setStatus(false);
		userQuery.setRaisedOn(new Date());
		userQueryRepository.save(userQuery);	//save query for given employee who raised it
		
		List<UserQuery> userQueries= employee.getUserQuery();
		userQueries.add(userQuery);
		employeeRepository.save(employee);		// also save user
	}

}
