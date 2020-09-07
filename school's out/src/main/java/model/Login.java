package model;

import javax.persistence.*;

@Entity
public class Login {
    @Id
    private String login;

    private String passwordHash;

    private String salt;

    private Boolean active;
    @OneToOne
    @JoinColumn(name="UserID")
    private User user;



    public String getLogin() {
        return login;
    }

    public Login setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Login setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public Login setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Login setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Login setUser(User user) {
        this.user = user;
        return this;
    }
}
