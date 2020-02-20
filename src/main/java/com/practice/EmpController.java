package com.practice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/employees")
	public List<employee>getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	@GetMapping("employees/{id}")
	public Optional<employee> getEmployeeById(@PathVariable final long id)
	
	{
		return employeeRepository.findById(id);
	}
	@PostMapping("/load")
	public employee createEmployee(@Valid @RequestBody employee emp) {
		
		return employeeRepository.save(emp);
	}
	@PutMapping("/update/{id}")
	public  employee UpdatedEmployee(@PathVariable final long id,@Valid @RequestBody employee emp1)
		{
	
		employee emp=employeeRepository.getOne(id);
		emp.setFirstname(emp1.getFirstname());
		emp.setLastname(emp1.getLastname());
		emp.setEmail(emp1.getEmail());
		employee updateemp=employeeRepository.save(emp);
		return updateemp;
	}
	@DeleteMapping("/delete/{id}")
	public  void  deleteEmployee(@PathVariable(value="id") final long id)
	{
	employeeRepository.deleteById(id);
		
		
	
		
	
	
}
}

