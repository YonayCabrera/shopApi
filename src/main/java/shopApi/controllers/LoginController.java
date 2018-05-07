package shopApi.controllers;

import org.springframework.web.bind.annotation.*;
import shopApi.domain.LoginDTO;

@RestController
public class LoginController {

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return "KEY";
    }
}
