package com.company.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contact")
    public String getContactInquiryDetails(){
        return "Herre is the contact enquiry details from db";
    }
}
