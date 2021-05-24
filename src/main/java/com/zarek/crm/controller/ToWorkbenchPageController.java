package com.zarek.crm.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@Log4j2
public class ToWorkbenchPageController {

    @GetMapping("/workbench/visit/{target}")
    public String toWorkbenchVisit(@PathVariable("target") String target){
        return "workbench/visit/"+target;
    }

    @GetMapping("/workbench/transaction/{target}")
    public String toWorkbenchTransaction(@PathVariable("target") String target){
        return "workbench/transaction/"+target;
    }

    @GetMapping("/workbench/main/{target}")
    public String toWorkbenchMain(@PathVariable("target") String target){
        return "workbench/main/"+target;
    }

    @GetMapping("/workbench/customer/{target}")
    public String toWorkbenchCustomer(@PathVariable("target") String target){
        return "workbench/customer/"+target;
    }

    @GetMapping("/workbench/contacts/{target}")
    public String toWorkbenchContacts(@PathVariable("target") String target){
        return "workbench/contacts/"+target;
    }

    @GetMapping("/workbench/clue/{target}")
    public String toWorkbenchClue(@PathVariable("target") String target){
        return "workbench/clue/"+target;
    }

    @GetMapping("/workbench/chart/{target}")
    public String toWorkbenchChart(@PathVariable("target") String target){
        return "workbench/chart/"+target;
    }

    @GetMapping("/workbench/activity/{target}")
    public String toWorkbenchActivity(@PathVariable("target") String target){
        return "workbench/activity/"+target;
    }

    @GetMapping("/workbench/{target}")
    public String toWorkbench(@PathVariable("target") String target){
        return "workbench/"+target;
    }

    @GetMapping("/")
    public String forward(){

        return "login";
    }

}
