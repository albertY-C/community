package chaoimi.community.controller;

import chaoimi.community.Provider.GitHubProvider;
import chaoimi.community.dto.AccessTokenDTO;
import chaoimi.community.dto.GitHubUser;
import chaoimi.community.mapper.UserMapper;
import chaoimi.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.SchemaOutputResolver;
import java.util.UUID;
import java.util.concurrent.PriorityBlockingQueue;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String ClientId;
    @Value("${github.client.secret}")
    private String ClientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired(required = false)
    private UserMapper userMapper;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(ClientId);
        accessTokenDTO.setClient_secret(ClientSecret);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser githubUser = gitHubProvider.getUser(accessToken);
        if(githubUser != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvataUrl(githubUser.getAvatarUrl());
            userMapper.insert(user);
            //2020-03-15
            response.addCookie(new Cookie("token", token));
            // 登陆成功，写cookie和session
            request.getSession().setAttribute("user", githubUser);
            return "redirect:/";
        }else {
            // 登陆失败
            return "redirect:/";
        }
    }
}
