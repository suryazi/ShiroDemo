package com.example

import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(User)
@Mock([Role, Permission])
class UserSpec extends ConstraintUnitSpec {

    def setup() {
    	mockForConstraintsTests(User, [new User(username:'test@test.com')])
    }

    @Unroll("test User all constraints #field is #error")
    def "test User all constraints"(){
    	when:
    	def obj=new User("$field":val)

    	then:
    	validateConstraints(obj, field, error)

    	where:
    	error					|	field					|	val
    	'nullable'				|	'username'				|	''
    	'nullable'				|	'username'				|	null
    	'email'					|	'username'				|	getEmail(false)
    	'unique'				|	'username'				|	'test@test.com'
    	'valid'					|	'username'				|	getEmail(true)
    	'nullable'				|	'passwordHash'			|	''
    	'nullable'				|	'passwordHash'			|	null
    	'nullable'				|	'passwordSalt'			|	''
    	'nullable'				|	'passwordSalt'			|	null
    }

    @Unroll("User #field using #val results in #result")
    def "test username constraints"(){
        when:
        def obj=new User("$field":val)

        then:
        validateResults(obj,field,result)

        where:
        result  |   field           |   val
        false   |   'username'      |   getEmail(false)
        true    |   'username'      |   getEmail(false)+"iamipd.gov"
    }

    @Unroll("User #field testing #error")
    def "test User Role constraints"(){
        when:
        def obj=new User("$field":val)

        then:
        validateConstraints(obj, field, error)

        where:
        error                   |   field                   |   val
        'valid'                 |   'role'                  |   null
        'valid'                 |   'role'                  |   createRole(1)
    }

    @Unroll("User #field testing #error")
    def "test User Permission constraints"(){
        when:
        def obj=new User("$field":val)

        then:
        validateConstraints(obj, field, error)

        where:
        error                   |   field                   |   val
        'valid'                 |   'permission'            |   null
        'valid'                 |   'permission'            |   createPermission(1)
    }

    private createRole(Integer count){
        def roles=[]
        count.times{
            roles<<new Role()
        }
        roles
    }

    private createPermission(Integer count){
        def permissions=[]
        count.times{
            permissions<<new Permission()
        }
        permissions
    }
}
