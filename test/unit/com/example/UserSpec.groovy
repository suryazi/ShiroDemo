package com.example

import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends ConstraintUnitSpec {

    def setup() {
    	mockForConstraintsTests(User, [new User(username:'test@test.com')])
    }

    @Unroll("test User all constraints #field is #error")
    def "test user all constraints"(){
    	when:
    	def obj=new User("$field":val)

    	then:
    	validateConstraints(obj, field, error)

    	where:
    	error					|	field					|	val
    	'nullable'				|	'username'				|	''
    	'nullable'				|	'username'				|	null
    	'unique'				|	'username'				|	'test@test.com'
    	'valid'					|	'username'				|	'user@test.com'
    }
}
