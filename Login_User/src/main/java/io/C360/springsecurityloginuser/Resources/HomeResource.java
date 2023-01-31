package io.C360.springsecurityloginuser.Resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String Home()
    {
        return ("<h1> WELCOME TO HOMEEEE </h1>");
    }

    @GetMapping("/user")
    public String UserMethod(){ return ("<h1> WELCOME TO USER LOGIN </h1>"); }

    @GetMapping("/admin")
    public String AdminMethod(){ return  ("<h1> WELCOME TO ADMIN PAGE !!!!!</h1> "); }

}
