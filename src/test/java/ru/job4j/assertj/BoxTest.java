package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(10, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isGetNumberSuccessfully() {
        Box box = new Box(8, 5);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8);
    }

    @Test
    void isGetNumberNotFound() {
        Box box = new Box(15, 5);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(-1);
    }
    @Test
    void isThisTrue() {
        Box box = new Box(0, 5);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isThisFalse() {
        Box box = new Box(-1, 5);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }
    @Test
    void isCheckArea() {
        Box box = new Box(4, 5);
        double result = box.getArea();
        assertThat(result).isEqualTo(43.30, withPrecision(0.01));
    }

    @Test
    void isCheckAreaNotFound() {
        Box box = new Box(20, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }
}