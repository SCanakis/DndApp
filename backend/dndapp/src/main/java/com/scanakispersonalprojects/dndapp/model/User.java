package com.scanakispersonalprojects.dndapp.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * A very small JPA entity that represents a single user of the app.
 * 
 * It only keep three things:
 *  - uuid : the automatic primary key
 *  - username : thje login name
 *  - passwordHash : the hasehd password.
 */


@Entity
@Table(name="users")
public class User {

    /** Primary key geneated as a UUID */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_uuid")
    private UUID uuid;

    /** Unique login name for the user */
    @Column(nullable = false, unique = true)
    private String username;

    /** Hashed password */
    @Column(name="password")
    private String passwordHash;

    /** JPA needs a no-args constructor. */
    protected User() {}

    /**
     * Creates a new user with the given username and password hash.
     * 
     * @param username
     * @param passwordHash
     */
    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // Setters and Getters

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    

}