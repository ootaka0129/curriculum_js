package chatGPT1;

public class Inventory {

    List<Product> p = new ArrayList<Product>();
    
    //商品を追加するためのメソッド 
    public void addProduct(Product product){
        p.add(product);
        System.out.println(product + "を追加しました。")
    }
    //特定の商品名で商品を検索するためのメソッド
    //検索するときは一つ一つ出力した後に、名前の一致を確かめる
    public findProductByName(String name){
        for(Product product : p){
            if(product.getName().equals(name)){
                return product;
            }
            return null;
        }
    }
}