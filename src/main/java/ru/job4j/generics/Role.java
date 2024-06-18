package ru.job4j.generics;

public class Role extends Base {
    private final String username;

    public Role(String id, String name) {
        super(id);
        this.username = name;
    }

    public String getUsername() {
        return username;
    }
}
