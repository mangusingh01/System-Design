package Inheritance.StaffRoles;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Person {
    private final String name;
    private final List<Role> roles = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person addRole(Role r) {
        roles.add(r);
        return this;
    }

    public <T extends Role> boolean hasRole(Class<T> type) {
        return roles.stream().anyMatch(type::isInstance);
    }

    public String describe() {
        String r = roles.stream().map(Role::describe).collect(Collectors.joining(", "));
        return name + ": " + (r.isEmpty() ? "no roles" : r);
    }
}
