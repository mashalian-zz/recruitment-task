package se.telenor.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.recruitment.service.GreetingService;


@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Welcome to greeting task", HttpStatus.OK);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ResponseEntity<String> greeting(@RequestParam(value = "account") String account,
                                           @RequestParam(value = "id", required = false) Integer id,
                                           @RequestParam(value = "type", required = false) String type) {

        String greeting = greetingService.greeting(account, id, type);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
