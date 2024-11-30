package member;

public class AdminUser extends User {
    
    private String adminCode;
    
    public AdminUser(String name, String mail, String adminCode){ //管理者のコンストラクタ
        super(name, mail);                                        //superで親クラスのコンストラクタを呼びだす
        this.adminCode = adminCode;
    }
    
    
    @Override
    public String toString(){
        return "管理者名：" + getName() + "　メールアドレス：" + getMail() + "　管理者コード：" + getAdminCode();
    }
}
