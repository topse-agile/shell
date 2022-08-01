package jp.topse.agile;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayInputStream;

public class ShellTest {
    @Test
    public void testSomething() {
        assertThat(1, is(1));
    }

    @Test
    public void test_getInputReturnTheString() {
        Shell shell = new Shell();
        shell.setInputStream(new ByteArrayInputStream("topse".getBytes()));

        String input = shell.getInput();

        assertThat(input, is("topse"));
    }

    @Test
    public void test_echoOutputTheString() {
        Shell shell = new Shell();
        StringBuffer buffer = new StringBuffer();
        shell.setOutput(new Shell.Output() {
            public void print(String s) {
                buffer.append(s);
            }
        });

        shell.echo(new String[] { "echo", "AAA" });

        assertThat(buffer.toString(), is("AAA\n"));
    }
}
