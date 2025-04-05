package com.vti.testing.entity;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, unique = true, nullable = false)
    private String username;
    @Column(name = "`password`", length = 800, nullable = false)
    private String password;
    @Column(name = "`first_name`", length = 50, nullable = false)
    private String firstName;
    @Column(name = "`last_name`", length = 50, nullable = false)
    private String lastName;
    @Column(name = "`role`", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = Role.EMPLOYEE;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
