package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenFileWithCommentsAndEmptyLines() {
        String path = "./data/file_with_comments_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("5")).isEqualTo("Ivan Ivanov");
        assertThat(config.value("1")).isEqualTo("Emil Mustafaev");
        assertThat(config.value("7")).isEqualTo("Alex Sidorov");
    }

    @Test
    void whenFileWithInvalidFormatThenThrowException() {
        String path = "./data/invalid_format.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenFileWithMultipleEqualsSigns() {
        String path = "./data/multiple_equals_signs.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key1")).isEqualTo("value1=value2");
        assertThat(config.value("key2")).isEqualTo("value3=");
    }
}