package com.olol.spring.web.dao;

import com.olol.spring.web.validation.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author boaztu
 */
@Entity
@Table(name = "users")
public class User {

    @NotBlank(groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 8, max = 15, groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Pattern(regexp = "^\\w{8,}$", groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Id
    @Column(name = "username")
    private String username;

    @NotBlank(groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Pattern(regexp = "^\\S+$", groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 8, max = 15, groups = {FormValidationGroup.class})
    private String password;

    @ValidEmail(groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    private String email;

    @NotBlank(groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 8, max = 60, groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    private String name;

    private boolean enabled = false;
    private String authority;

    public User() {

    }

    public User(final String username, final String name, final String password, final String email, final boolean enabled, final String authority) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(final String authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        if (enabled != user.enabled) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return !(authority != null ? !authority.equals(user.authority) : user.authority != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
