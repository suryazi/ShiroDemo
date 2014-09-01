package com.example

class ShiroTagLib {
    static namespace="shiro"
    static defaultEncodeAs='html'

    def thisYear={
    	out<<Calendar.getInstance().get(Calendar.YEAR)
    }

    def copyright={ attrs, body ->
    	out<<"${attrs['startYear']} - ${thisYear()}, ${body()}"
    	out<<" All Rights Reserved."
    }
}
