package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {

    @Test
    void whenGenerateCorrect() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Emil Mustafaev",
                "subject", "you");
        Generator generator = new GeneratorImpl();
        String result = generator.produce(template, args);
        assertThat(result).isEqualTo("I am Emil Mustafaev, Who are you?");
    }

    @Test
    void whenKeyIsMissingThenThrowException() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Emil Mustafaev");
        Generator generator = new GeneratorImpl();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenKeyInMapThenThrowException() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Emil Mustafaev",
                "subject", "you", "key", "value");
        Generator generator = new GeneratorImpl();
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenEmptyTemplateThenReturnEmpty() {
        String template = "";
        Map<String, String> args = Map.of();
        Generator generator = new GeneratorImpl();
        String result = generator.produce(template, args);
        assertThat(result).isEqualTo("");
    }
}