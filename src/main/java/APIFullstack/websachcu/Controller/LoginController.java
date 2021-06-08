package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Request.LoginRequest;
import APIFullstack.websachcu.Repository.UserRepository;
import APIFullstack.websachcu.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public String loginPage(Model modelLoginPage){
        modelLoginPage.addAttribute("loginRequest",new LoginRequest());
        return "login";
    }

    @PostMapping
    public String loginPage(Model modelLoginPage,
                            @ModelAttribute("loginRequest") LoginRequest loginRequest){
        String runLoginRequest = loginService.runLoginService(loginRequest);
        modelLoginPage.addAttribute("messageLogin" , runLoginRequest);
        return "login";
    }
}
