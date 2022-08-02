package jp.topse.agile.commands;

import org.junit.jupiter.api.Test;

import jp.topse.agile.Shell;
import jp.topse.agile.commands.Echo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EchoTest {
    @Test
    public void test_echoOutputTheString() {
        // Echoオブジェクトのexecuteに ["echo", "AAA"] を渡すと、AAAと表示される
    }
}
