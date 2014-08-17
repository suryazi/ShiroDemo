package com.example

class HomeController {

    def index() { 
    	render "Success - This page requires a user to be logged in"
    }

    def admin(){
    	render "Success - This page requires the logged in user to be an Administrator"
    }
}
