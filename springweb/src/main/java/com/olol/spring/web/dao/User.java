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
}
