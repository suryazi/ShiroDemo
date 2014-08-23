package com.example

import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Role)
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
}
