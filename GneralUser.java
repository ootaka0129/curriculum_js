package member;

public class GeneralUser extends User {
    
    public GeneralUser(String name, String mail) {
        super(name, mail);
        }
    
    
    @Override
    public String toString() {
        return "ユーザー名：" + name + "　メールアドレス：" + mail;
    }
        
}
