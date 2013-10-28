package pl.rawie.strcalc;

import org.hamcrest.Matcher;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    private int add(String input) {
        return new StringCalculator().add(input);
    }

    private void assertThatExceptionMessageFor(String input, Matcher<String> matcher) {
        try {
            add(input);
            fail("Should failed");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), matcher);
        }
    }

    @Test
    public void emptyString() {
        assertThat(add(""), is(equalTo(0)));
    }

    @Test
    public void oneNumber() {
        assertThat(add("1"), is(equalTo(1)));
    }

    @Test
    public void twoNumbers() {
        assertThat(add("1,2"), is(equalTo(3)));
    }

    @Test
    public void multipleNumbers() {
        assertThat(add("1,2,3"), is(equalTo(6)));
    }

    @Test
    public void newLineDelimiter() {
        assertThat(add("1\n2,3"), is(equalTo(6)));
    }

    @Test
    public void definedDelimiter() {
        assertThat(add("//;\n1;2"), is(equalTo(3)));
    }

    @Test
    public void definedDelimiterWithEmptyString() {
        assertThat(add("//;\n"), is(equalTo(0)));
    }

    @Test
    public void oneNegative() {
        assertThatExceptionMessageFor("1,-1", is(equalTo("-1")));
    }

    @Test
    public void twoNegatives() {
        assertThatExceptionMessageFor("1,-1,2,-2", is(equalTo("-1,-2")));
    }
}
