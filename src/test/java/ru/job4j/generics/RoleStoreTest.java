package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenUsernameIsAlex() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("5", "Alex"));
        Role result = roleStore.findById("5");
        assertThat(result.getUsername()).isEqualTo("Alex");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("3", "Vasilii"));
        Role result = roleStore.findById("15");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsAndrey() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("2", "Andrey"));
        roleStore.add(new Role("2", "Oleg"));
        Role result = roleStore.findById("2");
        assertThat(result.getUsername()).isEqualTo("Andrey");
    }

    @Test
    void whenReplaceThenUsernameIsStas() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "IVan"));
        roleStore.replace("1", new Role("1", "Stas"));
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Stas");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Inokentiy"));
        roleStore.replace("10", new Role("10", "Oleg"));
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Inokentiy");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Emil'"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsAlexey() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Alexey"));
        roleStore.delete("10");
        Role result = roleStore.findById("1");
        assertThat(result.getUsername()).isEqualTo("Alexey");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Leonid"));
        boolean result = roleStore.replace("1", new Role("1", "Mikhail"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        UserStore store = new UserStore();
        store.add(new User("1", "Leonid"));
        boolean result = store.replace("10", new User("10", "Mikhail"));
        assertThat(result).isFalse();
    }

}