package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    @DisplayName("replace 테스트")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("콤마를 이용한 split 테스트")
     void splitByComma() {
        String actual = "1,2";
        String[] splitResult = actual.split(",");
        assertThat(splitResult).contains(splitResult[0], splitResult[1]);
    }

    @Test
    @DisplayName("1을 잘 가져오는지 체크하는 split 테스트")
     void getOneBySplit() {
        String actual = "1";
        String[] splitResult = actual.split(",");
        assertThat(splitResult).containsExactly(actual);
    }

    @Test
    @DisplayName("subString 테스트")
     void subString() {
        String actual = "(1,2)";
        String subStringResult = actual.substring(1,4);
        assertThat(subStringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
     void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
        assertThat(actual.charAt(actual.length() - 1)).isEqualTo('c');
    }

    @Test
    @DisplayName("AssertThatExceptionOfType 사용해서 StringIndexOutOfBoundsException")
     void StringIndexOutOfBoundsExceptionUsingAssertThatExceptionOfType() {
        String actual = "abc";
        int outIndex = actual.length();

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> actual.charAt(outIndex))
                .withMessageMatching(String.format("String index out of range: %d", outIndex));

    }

    @Test
    @DisplayName("AssertThatThrownBy 사용해서 StringIndexOutOfBoundsException")
    void StringIndexOutOfBoundsExceptionUsingAssertThatThrownBy() {
        String actual = "abc";
        int outIndex = actual.length();

        assertThatThrownBy(() -> actual.charAt(outIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", outIndex));
    }
}
