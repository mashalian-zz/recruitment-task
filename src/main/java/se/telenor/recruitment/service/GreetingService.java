package se.telenor.recruitment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.telenor.recruitment.exceptions.InvalidUserIdException;
import se.telenor.recruitment.exceptions.PathNotImplementedException;

import java.util.Objects;

@Service
public class GreetingService {

    private static Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    public String greeting(String account, Integer id, String type) {
        if (Objects.nonNull(id) && id <= 0) {
            LOGGER.info("Invalid userId");
            throw new InvalidUserIdException("Id can not be less than zero!");
        }
        String response = null;
        if (account.equals("personal")) {
            response = String.format("Hi, userId %d", id);
        } else if (account.equals("business") && type.equals("big")) {
            response = "Welcome business user.";
        } else if (account.equals("business") && type.equals("small")) {
            LOGGER.error("Path for account business and type small is not implemented.");
            throw new PathNotImplementedException("The path is not yet implemented");
        }
        return response;
    }
}
