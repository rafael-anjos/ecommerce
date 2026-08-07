package com.api.ecommerce.core.domain.entity;

import com.api.ecommerce.core.domain.valueobject.user.Email;
import com.api.ecommerce.core.domain.valueobject.user.UserName;
import com.api.ecommerce.core.domain.valueobject.user.PasswordHash;
import com.api.ecommerce.core.domain.valueobject.user.UserId;

public class User {
    
    private final UserId id;

    private UserName name;

    private Email email;

    private PasswordHash password;

    // New user
    public User ( UserName name, Email email, PasswordHash password ) {
        this.id = UserId.generate();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // User exists ( rebuilding )
    private User ( UserId id, UserName name, Email email, PasswordHash password ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserId getId () { return id; }

    public UserName getName () { return name; }

    public Email getEmail () { return email; }

    public PasswordHash getPassword () { return password; }

    public void changeName ( UserName name ) {

        this.name = name;

    }

    public void changeEmail ( Email email ) {

        this.email = email;

    }
    
    public static User restore ( UserId id, UserName name, Email email, PasswordHash password ) {

        return new User(id, name, email, password);
        
    }
}
