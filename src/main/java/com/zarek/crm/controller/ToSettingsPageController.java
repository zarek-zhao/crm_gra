package com.zarek.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */

@Controller
public class ToSettingsPageController {

    @GetMapping("/settings/qx/user/{target}")
    public String toSettingsQxUser(@PathVariable("target") String target){
        return "settings/qx/user/"+target;
    }

    @GetMapping("/settings/qx/{target}")
    public String toSettingsQx(@PathVariable("target") String target){
        return "settings/qx/"+target;
    }

    @GetMapping("/settings/dictionary/value/{target}")
    public String toSettingsDictionaryValue(@PathVariable("target") String target){
        return "settings/dictionary/value/"+target;
    }

    @GetMapping("/settings/dictionary/type/{target}")
    public String toSettingsDictionaryType(@PathVariable("target") String target){
        return "settings/dictionary/type/"+target;
    }

    @GetMapping("/settings/dictionary/{target}")
    public String toSettingsDictionary(@PathVariable("target") String target){
        return "settings/dictionary/"+target;
    }


    @GetMapping("/settings/dept/{target}")
    public String toSettingsDept(@PathVariable("target") String target){
        return "settings/dept/"+target;
    }

    @GetMapping("/settings/{target}")
    public String toSettings(@PathVariable("target") String target){
        return "settings/"+target;
    }
}
