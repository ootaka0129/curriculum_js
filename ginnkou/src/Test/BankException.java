package Test;
//Excepotion 独自のExcepotionを継承している
public class BankException extends Exception {
    public BankException(String message) {
        super(message);
    }
    //親クラスのコンストラクタを呼びだすときにsuperを使用する
}
