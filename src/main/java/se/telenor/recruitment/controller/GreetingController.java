package se.telenor.recruitment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.recruitment.exceptions.InvalidUserIdException;
import se.telenor.recruitment.exceptions.PathNotImplementedException;

import java.util.Objects;


@RestController
public class GreetingController {


    @RequestMapping(value = "/greeting and verify the behavior", method = RequestMethod.GET)
    public ResponseEntity<String> greeting(@RequestHeader String account,
                                           @RequestHeader(required = false) Integer id,
                                           @RequestHeader(required = false) String type) {
        if (Objects.nonNull(id) && id < 0)
            throw new InvalidUserIdException("Id can not be less than zero!");

        String response = null;
        if (account.equals("personal")) {
            response = String.format("Hi, userId %d", id);
        } else if (account.equals("business") && type.equals("big")) {
            response = "Welcome business user.";
        } else if (account.equals("business") && type.equals("small")) {
            throw new PathNotImplementedException("The path is not yet implemented");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
