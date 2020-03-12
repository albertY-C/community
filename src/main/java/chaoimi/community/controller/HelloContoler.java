package chaoimi.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
* Created by coderrinker on 2020/03/12
*/
@Controller
public class HelloContoler {
    @GetMapping( "/hello" )
    public  String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
