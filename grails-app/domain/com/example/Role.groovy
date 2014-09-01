package com.example
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeNames = true, includeFields = true)
class Role {
    String name
    Date dateCreated
    Date lastUpdated

    static hasMany = [ users: User, permissions: Permission ]
    static belongsTo = User

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
}
