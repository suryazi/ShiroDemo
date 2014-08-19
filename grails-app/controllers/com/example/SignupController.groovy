package com.example

import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.SecurityUtils
import com.example.Role
import com.example.User
import org.apache.shiro.crypto.hash.Sha512Hash
import org.apache.shiro.crypto.RandomNumberGenerator
import org.apache.shiro.crypto.SecureRandomNumberGenerator

class SignupController {

    def index() {
        User user = new User()
        [user: user]
    }

    def register() {

        // Check to see if the username already exists
        def user = User.findByUsername(params.username)
        if (user) {
            flash.message = "User already exists with the username '${params.username}'"
            redirect(action:'index')
        }

        // User doesn't exist with username. Let's create one
        else {

            // Make sure the passwords match
            if (params.password != params.password2) {
                flash.message = "Passwords do not match"
                redirect(action:'index')
            }

            // Passwords match. Let's attempt to save the user
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