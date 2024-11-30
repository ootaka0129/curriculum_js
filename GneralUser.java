package member;

public class GeneralUser extends User {
    
    public GeneralUser(String name, String mail) {
        super(name, mail);
    }
    
    //name,mailを外部（setter以外)からアクセスしないためにgetterを使用する
    @Override
    public String toString() {
        return "ユーザー名：" + getName() + "　メールアドレス：" + getMail();
    }
}
