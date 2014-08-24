package com.example
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeNames = true, includeFields = true)
class User {
    String username
    String passwordHash
    byte[] passwordSalt
    
    static hasMany = [ roles: Role, permissions: Permission ]

    static constraints = {
        username(nullable: false, blank: false, unique: true, email:true)
        passwordHash(nullable: false, blank: false)
        passwordSalt(nullable: false, blank: false)
    }
}
