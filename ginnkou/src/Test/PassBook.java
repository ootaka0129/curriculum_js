package Test;

public class PassBook implements Pass {

	// 名前
	private String name;

	// 支店番号
	private int branchNumber;

	// 口座番号
	private int accountNumber;

	// 残高
	private int money;

    //外部から値を取得することができる
	public String getName(){
		return name;
	}

	public int getBranchNumber(){
		return branchNumber;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public int getMoney(){
		return money;
	}

	
	public PassBook(String name, int branchNumber, int accountNumber, int money) {
		this.name = name;
		this.branchNumber = branchNumber;
		this.accountNumber = accountNumber;
		this.money = money;
	}
	//残高確認メソッド
	public void checkBalance(){                                
		System.out.println("現在の残高は"  + money);
	}
	//預入
	public void deposit(int en) throws BankException{//コンストラクタの後ろに例外をなげる
		if (en <= 0) {          //預入したい金額がマイナスになっているから預入できない
        throw new BankException("預入できません。"); //BankExcepotionに引数としてメッセージを受け取り、BankExceptionコンストラクタに引き渡す
		}
		money += en; //残高に預入金額を追加
		System.out.println(en + "円を預入しました。現在の残高は: " + money + "円です。");
	}
	// 引き落とし
    public void withdraw(int en) throws BankException {//コンストラクタの後ろに例外を投げる
        if (en <= 0) {        //引き落としたい金額がマイナスになってるから引き落としができない
            throw new BankException("引き落としができません。"); //BankExceptionに引数としてメッセージを受け取り、BankExceptionコンストラクタに引き渡す
        }
        if (en > money) {    //残高よりも引き落し金額が大きいから引き落としできない
            throw new BankException("残高不足のため、引き落としできません。");
        }
        money -= en; //残高から引き落としを実行
        System.out.println(en + " 円を引き落としました。現在の残高は: " + money + " 円です。");
    }

	//振込処理
	public void transfer(PassBook ma, PassBook mb, int en) throws BankException {//コンストラクタの後ろに例外を投げる
    if (ma == mb) {  
        throw new BankException("振込元と振込先が同じです。振込できません。"); //BankExceptionに引数としてメッセージを受け取り、BankExceptionコンストラクタに引き渡す
    }
    if (en <= 0) {  //金額０円以下は振り込みできない
        throw new BankException("振込ができません。");//BankExceptionに引数としてメッセージを受け取り、BankExceptionコンストラクタに引き渡す
    }
    if (ma.getMoney() < en) {
        throw new BankException("残高が不足しています。振込できません。");//BankExceptionに引数としてメッセージを受け取り、BankExceptionコンストラクタに引き渡すｓ
    }

    ma.money -= en; // 振込元から金額を引く
    mb.money += en; // 振込先に金額を加える

    System.out.println(en + " 円を振込しました。"); //振込金額の表示をする
    System.out.println("振込後の" + ma.getName() + "さんの残高: " + ma.getMoney() + " 円"); //振込元の残高を表示する
    System.out.println("振込後の" + mb.getName() + "さんの残高: " + mb.getMoney() + " 円"); //振込先の残高を表示する
	}
}
