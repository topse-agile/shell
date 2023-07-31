package jp.topse.agile.commands;

import jp.topse.agile.BaseMockTestCase;
import org.junit.jupiter.api.Test;

import jp.topse.agile.Shell;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class EchoTest extends BaseMockTestCase {

    @Mock
    Shell.Output output;

    @Test
    public void test_echoOutputTheString() {
        Echo echo = new Echo();

        echo.execute(new String[] { "echo", "AAA" }, output);

        verify(output).print("AAA");
    }
}