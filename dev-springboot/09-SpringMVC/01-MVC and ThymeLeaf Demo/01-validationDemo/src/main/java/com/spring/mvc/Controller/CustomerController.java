package com.spring.mvc.Controller;

import com.spring.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @GetMapping("/")
    public String getForm(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "customerForm";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute ("customer")Customer theCustomer,
                                BindingResult theBindingResult){
        System.out.println("|"+theCustomer.getLastName()+"|");
        if(theBindingResult.hasErrors())return "customerForm";
        else return "ConfirmationPage";
    }


}
