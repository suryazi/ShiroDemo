package com.example

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(ShiroTagLib)
class ShiroTagLibSpec extends Specification {

    void "test ShiroTagLib"(){
    	expect:
    	applyTemplate('<shiro:thisYear/>')==String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
    	applyTemplate('<shiro:copyright startYear="2013">Test.</shiro:copyright>')=='2013 - '+String.valueOf(Calendar.getInstance().get(Calendar.YEAR))+', Test. All Rights Reserved.'
    }

    void "test tag calls"(){
    	expect:
    	tagLib.thisYear().toString()==String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
    }
}
