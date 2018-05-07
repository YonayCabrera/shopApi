package shopApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domain.LoginDTO;
import shopApi.services.userServices.LogUser;

@RestController
public class LoginController {

    private LogUser logUser;

    @Autowired
    public LoginController(LogUser logUser){

        this.logUser = logUser;
    }
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return "Your Key is " + logUser.execute(loginDTO);
    }
}
