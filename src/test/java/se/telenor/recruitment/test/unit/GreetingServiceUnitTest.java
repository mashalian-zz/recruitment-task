package se.telenor.recruitment.test.unit;

import org.junit.Test;
import se.telenor.recruitment.exceptions.InvalidUserIdException;
import se.telenor.recruitment.exceptions.PathNotImplementedException;
import se.telenor.recruitment.service.GreetingService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingServiceUnitTest {

    private GreetingService greetingService = new GreetingService();

    @Test
    public void verifyHiUserId123() {
        String greeting = greetingService.greeting("personal", 123, null);
        assertNotNull(greeting);
        assertEquals("Hi, userId 123", greeting);
    }

    @Test
    public void verifyWelcomeBusinessUser() {
        String greeting = greetingService.greeting("business", null, "big");
        assertNotNull(greeting);
        assertEquals("Welcome business user.", greeting);
    }

    @Test(expected = InvalidUserIdException.class)
    public void getInvalidUserIdExceptionWhenIdIsNotPositiveIntegers() {
        greetingService.greeting("personal", 0, null);
    }

    @Test(expected = PathNotImplementedException.class)
    public void getPathNotImplementedExceptionWhenAccountIsBusinessAndTypeIsSmall() {
        greetingService.greeting("business", null, "small");
    }
}
