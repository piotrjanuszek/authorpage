package com.pjanuszek.page.authorpage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class User extends AbstractDomainClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    // I assume that below 3 values are required by spring security
    // TODO: Verify that
    private String username;
    private String password;
    @Builder.Default
    private Boolean enabled = true;

    public User() {
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, email='%s', password='%s']",
                id, email, password);
    }

}
