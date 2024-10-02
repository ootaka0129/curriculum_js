package chatGPT1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//機能（商品一覧を表示、商品の追加、商品の名前検索、在庫数を更新、終了）
		Scanner scanner = new Scanner(System.in);
		Inventory Inventory = new Inventory();

		for(;;){
			
			System.out.println("使用したい機能を選択して下さい。");
			System.out.println("1: 商品一覧");
			System.out.println("2: 商品検索");
			System.out.println("3: 商品の追加");
			System.out.println("4: 終了");
			System.out.println();
			int choice = scanner.nextInt();  //機能選択
			scanner.nextLine();
			
			switch(choice){
				case 1://商品一覧
					System.out.println("商品一覧を表示します。");
					Inventory.AllProductList();
					break;

				case 2://商品検索
					System.out.println("検索したい商品を入力してください。");
					String input = scanner.nextLine(); //商品入力
					Inventory.findProductByName(input);
					break;

				case 3://商品の追加
					System.out.println("追加したい商品名を入力してください。");
					String name = scanner.nextLine();
					System.out.println("追加したい商品の価格を入力してください。");
					int price = scanner.nextInt();
					System.out.println("追加したい商品の数量を入力してください。");
					int stock = scanner.nextInt();
					Product.addProduct(name, price, stock); //商品を追加するメソッドの呼び出し
					break;

				case 4:
					System.out.println("終了します。");
					scanner.close();
					break;
					
				default:
					System.out.println("もう一度入力してください。");
			}
		}
	}

}

