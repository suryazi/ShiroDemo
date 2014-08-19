import com.example.Role
import com.example.User
import org.apache.shiro.crypto.hash.Sha512Hash
import org.apache.shiro.crypto.RandomNumberGenerator
import org.apache.shiro.crypto.SecureRandomNumberGenerator

class BootStrap {
   
    def shiroSecurityService
   
    def init = { servletContext ->
   
        def adminRole = new Role(name: "Administrator")
        adminRole.addToPermissions("*:*")
        adminRole.save()
       
        def userRole = new Role(name:"User")
        userRole.addToPermissions("Home:index")
        userRole.save()
       
        def passwordSalt = new SecureRandomNumberGenerator().nextBytes().getBytes()
        def admin = new User(username: "Admin", passwordHash: new Sha512Hash("password", passwordSalt, 1024).toBase64(), passwordSalt:passwordSalt)
        admin.addToRoles(adminRole)
        admin.save()
       
        passwordSalt = new SecureRandomNumberGenerator().nextBytes().getBytes()
        def user = new User(username: "User", passwordHash: new Sha512Hash("password", passwordSalt, 1024).toBase64(), passwordSalt:passwordSalt)
        user.addToRoles(userRole)
        user.save()
    }

   
    def destroy = {
    }
}