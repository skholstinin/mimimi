package ru.skholstinin.testtask.security.model;

public final class Roles {
    public static final String ROLE_SUPERUSER = "admin";
    public static final String ROLE_USER = "user";

    private Roles() {
        throw new AssertionError();
    }
}
