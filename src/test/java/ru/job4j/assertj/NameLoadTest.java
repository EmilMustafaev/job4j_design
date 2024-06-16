package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void shouldThrowExceptionWhenNamesArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array");
    }

    @Test
    void shouldThrowExceptionWhenNameHasNoKey() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"Another = Name", "=Key = Value", "Name = Surname"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =Key = Value does not contain a key");
    }

    @Test
    void shouldThrowExceptionWhenNameLacksEqualSymbol() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"Another = Name", "Name = Surname", "Key : Value"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: Key : Value does not contain the symbol '='");
    }

    @Test
    void shouldThrowExceptionWhenNameHasNoValue() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"Another = Name", "Key Value="};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: Key Value= does not contain a value");
    }
}