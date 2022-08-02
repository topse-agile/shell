package jp.topse.agile.commands;

import jp.topse.agile.BaseMockTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.topse.agile.Shell;
import jp.topse.agile.commands.Echo;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;

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
