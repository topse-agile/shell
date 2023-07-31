package jp.topse.agile.commands;

import org.junit.jupiter.api.Test;

import jp.topse.agile.Shell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EchoTest {
    @Test
    public void test_echoOutputTheString() {
        Echo echo = new Echo();
        StringBuffer buffer = new StringBuffer();

        echo.execute(new String[] { "echo", "AAA" }, new Shell.Output() {
            public void print(String s) {
                buffer.append(s);
            }
        });

        assertThat(buffer.toString(), is("AAA\n"));
    }
}
