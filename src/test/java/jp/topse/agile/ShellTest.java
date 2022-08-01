package jp.topse.agile;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.*;

public class ShellTest {
    private static class ObservableOutput implements Shell.Output {
        private final StringBuffer stringBuffer = new StringBuffer();
        @Override
        public void print(String s) {
            stringBuffer.append(s);
        }

        public String getOutput() {
            return stringBuffer.toString();
        }
    }

    private final ObservableOutput output = new ObservableOutput();

    @Test
    public void test_executeEchoCommand() {
        Shell shell = new Shell();
        shell.setInput(new Shell.Input() {
            private final static String[] commands = {
                    "echo ABC",
                    "exit",
            };
            private int index = 0;
            @Override
            public String getLine() {
                return commands[index++];
            }
        });
        shell.setOutput(output);

        shell.run();

        assertThat(output.getOutput(), is(Shell.prompt + "ABC\n" + Shell.prompt));
    }
}
