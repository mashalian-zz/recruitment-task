package se.telenor.recruitment.service;

import org.springframework.stereotype.Service;
import se.telenor.recruitment.exceptions.InvalidUserIdException;
import se.telenor.recruitment.exceptions.PathNotImplementedException;

import java.util.Objects;

@Service
public class GreetingService {

    public String greeting(String account, Integer id, String type) {
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
        return response;
    }
}
