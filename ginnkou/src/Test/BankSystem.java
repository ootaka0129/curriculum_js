package Test;

import java.util.Map;
import java.util.Scanner;

public class BankSystem {
	public static void main(String[] args) {

		Map<Integer, PassBook> data = Data.start();  //<Integer, PassBook>:<整数,PassBookオブジェクトの値>   start():特定の処理を実行して、必要なデータを初期化または生成するためのメソッド

		Scanner s = new Scanner(System.in);
		for (;;) { //(;;)無限ループ
			System.out.println("ATMをご利用いただきありがとうございます。");
			System.out.println("本日の要件を数字で入力してください");
			System.out.println("--------------------------------------");
			System.out.println("1,残高確認");
			System.out.println("2,預入");
			System.out.println("3,引き落とし");
			System.out.println("4,お振込み");
			int input = s.nextInt();         //整数を読み取る
			System.out.println("--------------------------------------");
			System.out.println("使用する口座を選択してください");
			for (int i = 1; i <= data.size(); i++) {                         //size()dataの要素数を数える。dataの情報をすべて出力する。
				System.out.println(i + ":" + data.get(i).getName());
			}
			int user = s.nextInt(); //user変数に整数を入力して、get.(user)で取得したいデータを選択する。user=振込元
			System.out.println(data.get(user).getName() + "様ですね、ご利用ありがとうございます。");
			System.out.println();
			try {
				switch (input) {
				case 1:
					data.get(user).checkBalance(); //選択したユーザーの残高確認メソッド
					break;
				case 2:
					System.out.println("幾ら預けますか？");
					System.out.println("数字だけで入力ください");
					int moneyIn = s.nextInt();
					data.get(user).deposit(moneyIn);
					break;
				case 3:
					System.out.println("幾ら引き落としますか？");
					System.out.println("数字だけで入力ください");
					int moneyOut = s.nextInt();
					data.get(user).withdrawal(moneyOut);
					break;
				case 4:
					System.out.println("どなたに振込しますか？");
					for (int i = 1; i <= data.size(); i++) {
						System.out.println(i + ":" + data.get(i).getName());
					}
					int user2 = s.nextInt();
					System.out.println("幾ら引き落としますか？");
					System.out.println("数字だけで入力ください");
					int moneyPoint = s.nextInt();
					data.get(user).transfer(data.get(user), data.get(user2), moneyPoint);
					break;
				default:
					System.out.println("予期せぬ数字が入力されています。");
					System.out.println("もう一度初めから操作を行ってください");
					break;
				}
			} catch (NullPointerException e) { //値が何もないときに発生するエラー
				System.out.println("エラーが発生しました。もう一度初めから操作を行ってください");				
			} catch (BankException e) {
				e.printStackTrace();  //printStackTrace()エラーの内容を出力する
				System.out.println("エラーが発生しました。もう一度初めから操作を行ってください");
			} finally {
				System.out.println();
			}
		}
	}
}
