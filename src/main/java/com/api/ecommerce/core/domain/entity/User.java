package com.api.ecommerce.core.domain.entity;

import com.api.ecommerce.core.domain.valueobject.Email;
import com.api.ecommerce.core.domain.valueobject.Name;
import com.api.ecommerce.core.domain.valueobject.PasswordHash;
import com.api.ecommerce.core.domain.valueobject.UserId;

public class User {
    
    private final UserId id;

    private Name name;

    private Email email;

    private PasswordHash password;

    // New user
    public User ( Name name, Email email, PasswordHash password ) {
        this.id = UserId.generate();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // User exists ( rebuilding )
    private User ( UserId id, Name name, Email email, PasswordHash password ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserId getId () { return id; }

    public Name getName () { return name; }

    public Email getEmail () { return email; }

    public PasswordHash getPassword () { return password; }

    public void changeName ( Name name ) {

        this.name = name;

    }

    public void changeEmail ( Email email ) {

        this.email = email;

    }
    
    public static User restore ( UserId id, Name name, Email email, PasswordHash password ) {

        return new User(id, name, email, password);
        
    }
}
