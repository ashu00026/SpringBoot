package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Resource;
import com.luv2code.springboot.thymeleafdemo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resources")
public class ResourceController {

	private ResourceService resourceService;

	@Autowired
	public ResourceController(ResourceService theEmployeeService){
		this.resourceService =theEmployeeService;
	}


	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Resource>theResources= resourceService.findAll();

		// add to the spring model
		theModel.addAttribute("resources", theResources);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel){

		theModel.addAttribute("resources",new Resource());

		return "employees/registerEmployeeForm";
	}

	@PostMapping("/processForm")
	public String addEmployee(@ModelAttribute("resources") Resource theResources){
		resourceService.save(theResources);
		return "redirect:/resources/list";
	}
	//
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("resourceId")int theId,Model theModel){
		Resource theResource= resourceService.findById(theId);
		theModel.addAttribute("resources",theResource);
		return "employees/registerEmployeeForm";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("resourceId")int theId){
		resourceService.deleteById(theId);
		return "redirect:/resources/list";
	}
}









