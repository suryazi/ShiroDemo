package com.example

class User {
    String username
    String passwordHash
    byte[] passwordSalt
    
    static hasMany = [ roles: Role, permissions: Permission ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
        passwordHash(nullable: false, blank: false)
        passwordSalt(nullable: false, blank: false)
    }
}
