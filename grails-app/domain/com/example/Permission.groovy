package com.example
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated,lastUpdated,metaClass')
class Permission {
    String acl
    Date dateCreated
    Date lastUpdated

    static constraints = {
        acl(nullable: false, blank: false, unique: true)
    }
    
    static hasMany = [ users: User, roles: Role ]
    
    static belongsTo = [Role, User]

    String toString(){
    	"${acl}"
    }
}
