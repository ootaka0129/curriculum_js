package Test;

public interface Pass {
	
	//残金確認
	//口座内にある現在の残金を表示するメソッドです。
	public void checkBalance();
	
	//預入
	//指定した口座に対して、金額を入力することで値段を入れるメソッドです。
	public void deposit(int en) throws BankException; //throws は例外を投げる 

	//引き落とし
	//指定した口座に対して、金額を減らすメソッドです。
	//口座の残金はマイナス値になる場合は処理を中断する必要があります。
	public void withdrawal(int en) throws BankException ;

	//振込
	//複数の口座の指定を行い、金銭の移動を行う処理です。
	//振込側の残金はマイナス値になる場合は処理を中断する必要があります。
	public void transfer(PassBook ma,PassBook mb,int en) throws BankException ;
}
