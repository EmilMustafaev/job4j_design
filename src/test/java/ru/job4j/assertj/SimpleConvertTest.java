package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkConvertArrayToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three");
        assertThat(list).hasSize(3)
                .contains("three")
                .containsOnly("first", "second", "three")
                .contains("second", Index.atIndex(1))
                .containsAnyOf("ten", "second", "five")
                .doesNotContain("three", Index.atIndex(1))
                .startsWith("first")
                .endsWith("three");
        assertThat(list).first().isEqualTo("first");
        assertThat(list).element(0).isNotNull()
                .isEqualTo("first");
        assertThat(list).last().isNotNull()
                .isEqualTo("three");
    }

    @Test
    void checkConvertArrayToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> stringSet = simpleConvert.toSet("five", "six", "seven", "eight");
        assertThat(stringSet).hasSize(4)
                .contains("six")
                .containsExactlyInAnyOrder("five", "six", "seven", "eight")
                .containsAnyOf("ten", "eight", "first")
                .doesNotContain("first", "second");
        assertThat(stringSet).isNotNull()
                .anySatisfy(str -> {
                    assertThat(str).startsWith("se");
                    assertThat(str).isEqualTo("seven");
                });
    }

    @Test
    void checkConvertArrayToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsValues(0, 1, 2, 3, 4)
                .containsKeys("first", "second")
                .doesNotContainKey("ten")
                .doesNotContainValue(10)
                .containsEntry("first", 0);
    }
}