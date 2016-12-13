package chapter5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        return "home";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(){
        return "profile";
    }


}
