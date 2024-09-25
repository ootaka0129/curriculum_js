package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();  //複数のデータを１つにまとめられるもの user=リストの変数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //ユーザーの入力情報を受け取るためのオブジェクト
        boolean keepRunning = true;               //変数をtrueの状態で宣言する

        while (keepRunning) {  //trueの間繰り返す
            System.out.println("1. 一般ユーザーを登録");
            System.out.println("2. 管理者ユーザーを登録");
            System.out.println("3. ユーザー情報を表示");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt(); //int型整数を読みとる
            scanner.nextLine();  // 改行文字を消費

            switch (choice) {
                case 1:
                    registerGeneralUser(scanner); //一般ユーザーのメソッドの呼び出し
                    break;
                case 2:
                    registerAdminUser(scanner); //管理者ユーザーのメソッドの呼び出し
                    break;
                case 3:
                    findUsers(); //登録されているユーザーを表示するメソッドの呼び出し
                    break;
                case 4:
                    keepRunning = false; //変数をfalseにしてwhileが繰り返し処理できないようにする
                    break;
                default:
                    System.out.println("無効な選択です。");
            }
        }

        scanner.close();
    }

    // 一般ユーザーを登録するメソッド(名前とメール）
    public static void registerGeneralUser(Scanner s) {
        System.out.println("ユーザ名を入力してください");
        String name = s.nextLine();//行で入力を取得する
        System.out.println("メールアドレスを入力してください");
        String mail = s.nextLine();

        boolean duplicate = isEmailRegistered(mail); 
        if(duplicate == true){//trueの場合は重複している
            System.out.println("メールアドレスが重複しています");
            return;
        }
        
        User newUser = new User(name,mail);
        users.add(newUser);
        
        System.out.println("登録完了");
    }

    // 管理者ユーザーを登録するメソッド(名前とメールと管理者コード)
    public static void registerAdminUser(Scanner s) {
        System.out.println("管理者名を入力してください");
        String name = s.nextLine();
        System.out.println("メールアドレスを入力してください");
        String mail = s.nextLine();
        System.out.println("管理者コードを入力してください");
        String adminCode = s.nextLine();

        boolean duplicate = isEmailRegistered(adminCode);
        if(duplicate == true){
            System.out.println("管理者コードが重複しています");
            return;
        }
        
        AdminUser newAdminUser = new AdminUser(name, mail, adminCode);
        users.add(newAdminUser);
        
        System.out.println("登録完了");
        }
    
    // メールアドレスが既に登録されているか確認するメソッド
    public static boolean isEmailRegistered(String newMail) { //リストにあるメールアドレスと入力したメールアドレスを重複してるか確認したい      
        for(User user : users){  //user変数を使ってfor拡張構文でメールアドレスを一個一個確認する
            if(user.getMail.equals(newMail)){
                return true; //メールアドレスが重複していたらtrueで返す
            }
        }
        return false;
    }
    // 登録されたユーザーを表示するメソッド
    public static void findUsers() {
        for(User user: users){
            System.out.println(user);
        }
    
    
}



