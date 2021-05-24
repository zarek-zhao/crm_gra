package com.zarek.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@RequestMapping("/template")
@Controller
public class TemplateController {

    @GetMapping("/test1")
    public String test1(Model model){
        model.addAttribute("name","赵云");
        return "mytest1";
    }

    @GetMapping("/test2")
    public String test2(Model model){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","赵云");
        map.put("age",23);
        map.put("gender","男");
        list.add(map);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name","关羽");
        map1.put("age",45);
        map1.put("gender","男");
        list.add(map1);
        model.addAttribute("list",list);
        return "workbench/activity/test2";
    }
}
