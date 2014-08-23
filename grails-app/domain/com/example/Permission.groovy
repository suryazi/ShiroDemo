package com.example

class Permission {

    String acl

    static constraints = {
        acl(nullable: false, blank: false, unique: true)
    }
    
    static hasMany = [ users: User, roles: Role ]
    
    static belongsTo = [Role, User]
}
