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
    public void test_echoOutputTheString() {
        // Shellオブジェクトのechoメソッドのテスト
        // echoに [ "echo", "AAA" ]という配列を渡すと、AAAと出力される
    }
    
    @Test
    public void test_getInputReturnTheString() {
        // Shellオブジェクトのinputで適切な入力を受け取れる
    }

}
