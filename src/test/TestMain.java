package test;

import main.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestMain {

    @Test
    public void getInputLessThanOneChar() {
        String input = "";
        Integer result = Main.inputValidity(input);
        assertEquals(1, result);
    }

    @Test
    public void getInputMoreThanMax() {
        String input = "{}()[]{}()[]{}()[]{}()[]{}()[]{}()[]{}()[]{}()[]{[]}()[]{}()[]{}()[]{}([])[]{}()[]{}()[]{}()[]{}()[]{}()[]{}()[][";
        Integer result = Main.inputValidity(input);
        assertEquals(2, result);
    }

    @Test
    public void getInputValid() {
        String input = "([]){}(())";
        Integer result = Main.inputValidity(input);
        assertEquals(0, result);
    }

    @Test
    public void getInputNonBrackets() {
        String input = "Hello, World!";
        Integer result = Main.inputValidity(input);
        assertEquals(3, result);

    }

    @Test
    public void testCheckMatchingBracketsMatching() {
        String input = "([]){}(())";
        Boolean result = Main.checkMatchingBrackets(input);
        assertEquals(true, result);
    }

    @Test
    public void testCheckMatchingBracketsNonMatching() {
        String input = "([])}(())";
        Boolean result = Main.checkMatchingBrackets(input);
        assertEquals(false, result);
    }
}
