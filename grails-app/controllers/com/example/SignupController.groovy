package com.example

import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.SecurityUtils
import org.apache.shiro.crypto.hash.Sha512Hash
import org.apache.shiro.crypto.SecureRandomNumberGenerator

class SignupController {

    def index() {
        User user = new User()
        user: user

    }

    def register(RegistrationCommand rc) {

        // Check to see if the username already exists
        def user = User.findByUsername(params.username)
        if (user) {
            flash.message = "User already exists with the username '${params.username}'"
            redirect(action:'index')
        }

        // User doesn't exist with username. Let's create one
        else {
            if(rc.hasErrors()){
                flash.message = "password has errors please correct and resubmit"
                redirect(action:'index')
            }

            // Input data is santized.
            else {
                // Create user
                def passwordSalt = new SecureRandomNumberGenerator().nextBytes().getBytes()
                def password = params.password
                user = new User(
                        username: params.username,
                        passwordHash: new Sha512Hash(password, passwordSalt, 1024).toBase64(),passwordSalt:passwordSalt
                )

                if (user.save()) {

                    // Add USER role to new user
                    def userRole =  Role.findByName('User')
                    user.addToRoles(userRole)
                    user.save(flush:true)

                    // Login user
                    def authToken = new UsernamePasswordToken(user.username, params.password)
                    SecurityUtils.subject.login(authToken)
                    
                    redirect(controller: 'home', action: 'index')
                }
                else {
                    redirect(controller: 'auth', action: 'login')
                }
            }
        }
    }
}

class RegistrationCommand {
    String username
    String password
    String password2

    static constraints={
        password blank:false, validator: {pwd, rc->
            return pwd != rc.username
        }

        password2 blank:false, validator:{pwd2, rc->
            return pwd2==rc.password
        }
    }
}