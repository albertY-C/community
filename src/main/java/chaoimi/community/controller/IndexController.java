package chaoimi.community.controller;

import chaoimi.community.dto.PaginationDTO;
import chaoimi.community.dto.QuestionDTO;
import chaoimi.community.mapper.QuestionMapper;
import chaoimi.community.mapper.UserMapper;
import chaoimi.community.model.Question;
import chaoimi.community.model.User;
import chaoimi.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
    public class IndexController {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if( cookie.getName().equals("token") ){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
