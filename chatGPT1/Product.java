package chatGPT1;

public class Product {

    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }
    //staticメソッドがあればインスタンス化しなくてもアクセスできる
    //voidは、戻り値がないことを示す。
    //static void インスタンス化不要の戻り値のないメソッド
    public String toString(){
        return "商品名:" + name + "価格:" + price + "在庫数:" + stock;
    }

    // 商品を追加するメソッド
    public void addProduct(Product product){
        productList.add(Product);
    }

}
