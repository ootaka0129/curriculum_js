package member;

public class AdminUser extends User {
    
    private String adminCode;
    
    public AdminUser(String name, String mail, String adminCode){
        super(name, mail);
        this.adminCode = adminCode;
    }
    
    
    @Override
    public String toString(){
        return "管理者名：" + name + "　メールアドレス：" + mail + "　管理者コード：" + adminCode;
    }
}