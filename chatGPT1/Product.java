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

    //在庫数を更新するメソッド voidで戻り値なし
    public void updateStock(int amount){
        if(stock + amount <= 0){
            System.out.println("在庫数が０以下になっています。");
            break;
        }
        if(stock + amount >= 0){
            stock += amount;
            System.out.println("現在の在庫は、" + stock + "です。");
        }
    }
    
    //staticメソッドがあればインスタンス化しなくてもアクセスできる
    //voidは、戻り値がないことを示す。
    //static void インスタンス化不要の戻り値のないメソッド

    public String toString(){
        return "商品名:" + name + "価格:" + price + "在庫数:" + stock;
    }

}
