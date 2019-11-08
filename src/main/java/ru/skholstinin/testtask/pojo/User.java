package ru.skholstinin.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;
    private boolean isEnabled;
    private List<RoleAction> roleActions = new ArrayList<>();

    public User(String name,
                String surname,
                boolean isEnabled,
                String login,
                String password,
                String role) {

        this.name = name;
        this.surname = surname;
        this.isEnabled = isEnabled;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "is_enabled")
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "role", updatable = false, insertable = false)
    public List<RoleAction> getRoleActions() {
        if (roleActions == null) {
            return new ArrayList<>();
        }
        return Collections.unmodifiableList(roleActions);
    }
}
