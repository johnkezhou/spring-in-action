package chapter5.controller;

import chapter5.base.Spitter;
import chapter5.data.ISpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/11/24.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private ISpitterRepository spitterRepository;

    @Autowired
    public SpitterController(ISpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" +  spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
