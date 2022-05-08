package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메서드를 활용해 Set의 크기 확인")
    void size() {
        int numbersSize = numbers.size();
        int expectedSize = 3;
        assertEquals(numbersSize, expectedSize);
    }

    @ParameterizedTest
    @DisplayName("ParameterizedTest를 활용한 Set의 contain() 테스트")
    @ValueSource(ints = {1,2,3})
    void containsTest(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("Set contain() 테스트 true, false 모두 체크")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void containsTrueAndFalseTest(int number, boolean expected) {
        assertEquals(numbers.contains(number), expected);
    }

}
