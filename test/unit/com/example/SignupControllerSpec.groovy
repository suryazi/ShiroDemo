package com.example

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SignupController)
@Mock(User)
class SignupControllerSpec extends Specification {

    def populateValidParams(params){
    	assert params != null
    	params["username"]="test@test.com"
    	params["password"]="password"
    }

    void "Test the index action"(){

    	when:"The index action is executed"
    		controller.index()

    	then:"The index view is displayed"
    		response.text=='Register'
    }
}
