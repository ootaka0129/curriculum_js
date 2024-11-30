package member;

public class User {
    
    // ここに作成   
    private String name;
    private String mail;
    
    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
    
    public String getMail() {
        return mail;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "ユーザー名：" + getName() + "　メールアドレス：" + getMail();
    }
    //privateで外部からアクセスすることができない。そのため、getを通してしかname、mailの情報を取得できない。
    
    // ここまで
}
