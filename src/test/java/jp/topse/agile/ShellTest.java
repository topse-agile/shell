package jp.topse.agile;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class ShellTest extends BaseMockTestCase {
    @Mock
    private Shell.Input input;

    @Mock
    private Shell.Output output;

    @InjectMocks
    private Shell shell;

    @Test
    public void test_executeEchoCommand() {
        when(input.getLine()).thenReturn("echo ABC").thenReturn("exit");

        shell.run();

        InOrder inOrder = inOrder(output);
        inOrder.verify(output).print(Shell.prompt);
        inOrder.verify(output).print("ABC");
        inOrder.verify(output).print("\n");
        inOrder.verify(output).print(Shell.prompt);
    }
}
