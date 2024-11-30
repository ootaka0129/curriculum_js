package chatGPT1;

public class Product {

    private String name;
    private int price;
    private int stock;
    //オブジェクト＝設計図の処理
    public Product(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    //外部から取得するためにgetterを使用する
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
    //親クラスがないのにオーバーライドしている理由は、オブジェクトクラスを暗黙的に継承している
    @Override
    public String toString(){
        return " 商品名:" + name + " 価格:" + price + " 在庫数:" + stock;
    }

    //在庫数を更新するメソッド
    public void updateStock(int amount){
        if(stock + amount < 0){
            System.out.println("在庫数を更新できませんでした。");
        }else{
            stock += amount;
            System.out.println("在庫数を更新しました。");
            System.out.println("在庫数： " + stock);
            System.out.println();
        }

    }
    //価格を更新するメソッド
    public void updatePrice(int cost){
        if(cost <= 0){
            System.out.println("価格が０円以下のため、価格変更できませんでした。");
        }else if (cost >= 0) {
            this.price = cost; 
            System.out.println("価格を変更しました。");
            System.out.println("価格： " + price);
            System.out.println();
        }
    }

    

}

