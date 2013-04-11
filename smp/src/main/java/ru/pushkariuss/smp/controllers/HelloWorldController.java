package ru.pushkariuss.smp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pushkariuss.smp.dto.Pet;

import java.util.UUID;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "hello-world", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("pet", new Pet("dog", "Harrison"));
        return "hello-world";
    }

    @RequestMapping(value = "random-string", method = RequestMethod.GET)
    public String getRandomName() {
        return UUID.randomUUID().toString();
    }
}
