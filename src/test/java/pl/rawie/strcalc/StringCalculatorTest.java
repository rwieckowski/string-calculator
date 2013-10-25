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
}
