package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Request.RegisterRequest;
import APIFullstack.websachcu.Repository.UserRepository;
import APIFullstack.websachcu.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @GetMapping
    public String registerPage(Model model){
        model.addAttribute("registerRequest" , new RegisterRequest());
        return "register";
    }
    @PostMapping
    public String registerPage(Model modelRegisterPage,
                               @ModelAttribute("registerRequest") RegisterRequest registerRequest){
        String runRegisterRequest = registerService.runRegisterService(registerRequest);
        modelRegisterPage.addAttribute("messageRegister", runRegisterRequest);

        return "register";
    }
}
