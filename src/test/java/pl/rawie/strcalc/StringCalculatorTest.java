package pl.rawie.strcalc;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    private int add(String input) {
        return new StringCalculator().add(input);
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
}
