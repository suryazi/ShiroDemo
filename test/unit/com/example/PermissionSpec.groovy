package com.example

import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestFor(Permission)
@Mock([User, Role])
class PermissionSpec extends ConstraintUnitSpec {

    def setup() {
    	mockForConstraintsTests(Permission, [new Permission(acl:'*.*')])
    }

    @Unroll("test Permission all constraints #field is #error")
    def "test Permission all constraints"(){
    	when:
    	def obj=new Permission("$field":val)

    	then:
    	validateConstraints(obj, field, error)

    	where:
    	error					|	field					|	val
    	'nullable'				|	'acl'					|	''
    	'nullable'				|	'acl'					|	null
    	'unique'				|	'acl'					|	'*.*'
    	'valid'					|	'acl'					|	'Home:Index'
    }

    @Unroll("Permission #field using #val results in #result")
    def "test acl constraints"(){
        when:
        def obj=new Permission("$field":val)

        then:
        validateResults(obj,field,result)

        where:
        result  |   field           |   val
        false   |   'acl'           |   ''
        true    |   'acl'           |   getLongString(15)
    }

    @Unroll("Permission #field testing #error")
    def "test Permission User constraints"(){
    	when:
    	def obj=new Permission("$field":val)

    	then:
    	validateConstraints(obj, field, error)

    	where:
    	error					|	field					|	val
    	'valid'					|	'user'					|	null
        'valid'                 |   'user'                  |   createUser(1)
    }

    @Unroll("Permission #field testing #error")
    def "test Permission Role constraints"(){
        when:
        def obj=new Permission("$field":val)

        then:
        validateConstraints(obj, field, error)

        where:
        error                   |   field                   |   val
        'valid'                 |   'role'                  |   null
        'valid'                 |   'role'                  |   createRole(1)
    }

    private createUser(Integer count) {
        def users = []
        count.times {
            users << new User()
        }
        users
    }

    private createRole(Integer count){
        def roles=[]
        count.times{
            roles<<new Role()
        }
        roles
    }
}
