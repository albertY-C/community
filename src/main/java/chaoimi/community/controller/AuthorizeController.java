package chaoimi.community.controller;

import chaoimi.community.Provider.GitHubProvider;
import chaoimi.community.dto.AccessTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(code);
        accessTokenDTO.setRedirect_url("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("daa25e3521055d2553c6");
        accessTokenDTO.setClient_secret("97145a6f0760d9def9a86e5686266daaeb45b62b");
        gitHubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
