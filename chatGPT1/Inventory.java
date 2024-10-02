package chatGPT1;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Product> productList = new ArrayList<Product>();

    //商品一覧を表示するメソッド
    public void AllProductList(){
        for(Product products : productList){
            System.out.println(products);
        }
    }

    //在庫数を更新するメソッド voidで戻り値なし
    public void updateInventory(int amount){
        if(productList.getStock() + amount <= 0){ //在庫数が０以下のときの処理
            System.out.println("在庫数が０以下になっています。");
            return;
        }else if(productList.getStock() + amount >= 0){ //在庫数に、追加した数量の合計が０以上のときの処理
            int newStock = productList.getStock() + amount;
            System.out.println("現在の在庫は、" +  newStock + "です。");
        }
    }

    //特定の商品名で商品を検索するためのメソッド
    //検索するときは一つ一つ出力した後に、名前の一致を確かめる
    public String findProductByName(String name){
        for(Product product : productList){
            if(product.getName().equals(name)){
                System.out.println("検索した商品が見つかりました。");
                return product.getName();
            }
        }
        return null;
    }

}
