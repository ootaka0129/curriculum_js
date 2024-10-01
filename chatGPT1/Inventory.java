package chatGPT1;

public class Inventory {

    List<Product> productList = new ArrayList<Product>();

    //在庫数を更新するメソッド voidで戻り値なし
    public void updateInventory(int amount){
        if(getStock() + amount <= 0){
            System.out.println("在庫数が０以下になっています。");
            return;
        }else if(getStock() + amount >= 0){
            int updateStock = getStock() += amount;
            System.out.println("現在の在庫は、" +  updateStock + "です。");
        }
    }

    //特定の商品名で商品を検索するためのメソッド
    //検索するときは一つ一つ出力した後に、名前の一致を確かめる
    public Product findProductByName(String name){
        for(Product product : productList){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

}