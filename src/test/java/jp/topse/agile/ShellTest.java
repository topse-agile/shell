package jp.topse.agile;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayInputStream;

public class ShellTest {

    @Test
    public void test_echoOutputTheString() {
        // Shellオブジェクトのechoメソッドのテスト
        // shellに [ "echo AAA", "exit" ] とコマンドを入力すると、AAAと出力される
    }
}
