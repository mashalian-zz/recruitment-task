package se.telenor.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.recruitment.service.GreetingService;


@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/greeting and verify the behavior", method = RequestMethod.GET)
    public ResponseEntity<String> greeting(@RequestHeader String account,
                                           @RequestHeader(required = false) Integer id,
                                           @RequestHeader(required = false) String type) {

        String greeting = greetingService.greeting(account, id, type);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
