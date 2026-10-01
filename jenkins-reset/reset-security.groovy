import jenkins.model.*
import hudson.security.*

def jenkins = Jenkins.get()

jenkins.setSecurityRealm(HudsonPrivateSecurityRealm.allInstances()[0])

def realm = jenkins.getSecurityRealm()

if (realm instanceof HudsonPrivateSecurityRealm) {
    def user = realm.getUser("admin")
    if (user == null) {
        realm.createAccount("admin", "Admin@123456")
    } else {
        user.setPassword("Admin@123456")
        user.save()
    }
}

jenkins.save()