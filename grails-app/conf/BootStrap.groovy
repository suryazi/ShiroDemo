import com.example.Role
import com.example.User
import com.example.Permission
import org.apache.shiro.crypto.hash.Sha512Hash
import org.apache.shiro.crypto.SecureRandomNumberGenerator

class BootStrap {
   
    def shiroSecurityService
   
    def init = { servletContext ->
   
        def permissions =  new Permission(acl:"*:*")
        permissions.save()
        
        def adminRole = new Role(name: "Administrator")
        adminRole.addToPermissions(permissions)
        adminRole.save()
       
        permissions = new Permission(acl:"Home:index")
        permissions.save()
        def userRole = new Role(name:"User")
        userRole.addToPermissions(permissions)
        userRole.save()
       
        def passwordSalt = new SecureRandomNumberGenerator().nextBytes().getBytes()
        def admin = new User(username: "admin@test.com", passwordHash: new Sha512Hash("password", passwordSalt, 1024).toBase64(), passwordSalt:passwordSalt)
        admin.addToRoles(adminRole)
        admin.save()
       
        passwordSalt = new SecureRandomNumberGenerator().nextBytes().getBytes()
        def user = new User(username: "user@test.com", passwordHash: new Sha512Hash("password", passwordSalt, 1024).toBase64(), passwordSalt:passwordSalt)
        user.addToRoles(userRole)
        user.save()
    }

   
    def destroy = {
    }
}