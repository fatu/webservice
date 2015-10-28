package com.olol.spring.web.dao;

import com.olol.spring.web.validation.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author boaztu
 */
public class User {

    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 8, max = 15)
    @Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of numbers letters and the underscore character.")
    private String username;

    @NotBlank(message = "Password cannot be blank.")
    @Pattern(regexp = "^\\S+$", message = "Password cannot contain spaces.")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters long.")
    private String password;

    @ValidEmail(message = "This does not appear to be a valid email address.")
    private String email;
    private boolean enabled = false;
    private String authority;

    public User() {

    }

    public User(final String username, final String password, final String email, final boolean enabled, final String authority) {
        this.username = username;
        this.password = password;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        if (enabled != user.enabled) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return !(authority != null ? !authority.equals(user.authority) : user.authority != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
