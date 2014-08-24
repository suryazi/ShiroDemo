package com.example

import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Role)
@Mock([User, Permission])
class RoleSpec extends ConstraintUnitSpec {

    def setup() {
    	mockForConstraintsTests(Role, [new Role(name:'Admin')])
    }

    @Unroll("test Role all constraints #field is #error")
    def "test Role all constraints"(){
    	when:
    	def obj=new Role("$field":val)

    	then:
    	validateConstraints(obj, field, error)

    	where:
    	error					|	field					|	val
    	'nullable'				|	'name'					|	''
    	'nullable'				|	'name'					|	null
    	'unique'				|	'name'					|	'Admin'
    	'valid'					|	'name'					|	'User'
    }

    @Unroll("Role #field using #val results in #result")
    def "test name constraints"(){
        when:
        def obj=new Role("$field":val)

        then:
        validateResults(obj,field,result)

        where:
        result  |   field           |   val
        false   |   'name'           |   ''
        true    |   'name'           |   getLongString(15)
    }

    @Unroll("Role #field testing #error")
    def "test Role User constraints"(){
    	when:
    	def obj=new Role("$field":val)

    	then:
    	validateConstraints(obj, field, error)

    	where:
    	error					|	field					|	val
    	'valid'					|	'user'					|	null
        'valid'                 |   'user'                  |   createUser(1)
    }

    @Unroll("Role #field testing #error")
    def "test Role Permission constraints"(){
        when:
        def obj=new Role("$field":val)

        then:
        validateConstraints(obj, field, error)

        where:
        error                   |   field                   |   val
        'valid'                 |   'permission'            |   null
        'valid'                 |   'permission'            |   createPermission(1)
    }

    private createUser(Integer count) {
        def users = []
        count.times {
            users << new User()
        }
        users
    }

    private createPermission(Integer count){
        def permissions=[]
        count.times{
            permissions<<new Permission()
        }
        permissions
    }
}
