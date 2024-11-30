package chatGPT1;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    
    List<Product> productList = new ArrayList<Product>();

    //商品一覧を表示するメソッド
    //ひとつひとつ出力したいときに拡張for構文を使用する
    public void allProductList(){
        if(productList.size() == 0){//リストの要素を確認する
            System.out.println("商品を追加してません。商品を追加してください。");
            System.out.println();
        }else if(productList.size() > 0){
            for(Product products : productList){
            System.out.println(products);
            System.out.println();
            }
        }
    }
    // 商品を追加するメソッド(数量価格も同時に更新する)
    public void addProduct(Product product){//Productsからproductに引き渡している
        for(Product products : productList){
        //価格が異なり名前が同じの場合、価格を変更する
        if(products.getPrice() != product.getPrice() || products.getName().equals(product.getName())){
            product.updatePrice(product.getPrice());
            System.out.println();
            //retrnをつけたら処理が止まるから書かない
        }
        //リストにある名前=入力名 重複してたら更新
        if(products.getName().equals(product.getName())){
            products.updateStock(product.getStock());
            return;
        }
        }
        //商品を追加する
        productList.add(product); //product型（名前、価格、数量）を持った変数を、リストに追加する
        System.out.println("商品を追加しました。");
        System.out.println(product.toString());//引数でProductをproductと引き渡しているからtoStringはproduct.toStringになる
        System.out.println();
    }
    //特定の商品名で商品を検索するためのメソッド
    //検索するときは一つ一つ出力した後に、名前の一致を確かめる
    //商品情報をすべて返すから、Product型で設定する
    public String findProductByName(String name){
        for(Product product : productList){
            if(product.getName().equals(name)){
                return product.toString();  //商品があったら
            }
        }
        return null; //なかったら
    }

}
