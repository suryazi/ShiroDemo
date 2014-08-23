package com.example

import grails.test.mixin.TestFor
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Permission)
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

}
