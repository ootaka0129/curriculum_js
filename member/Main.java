package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {  //trueの間繰り返す
            System.out.println("1. 一般ユーザーを登録");
            System.out.println("2. 管理者ユーザーを登録");
            System.out.println("3. ユーザー情報を表示");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 改行文字を消費

            switch (choice) {
                case 1:
                    registerGeneralUser(scanner);
                    break;
                case 2:
                    registerAdminUser(scanner);
                    break;
                case 3:
                    findUsers();
                    break;
                case 4:
                    keepRunning = false;
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
        String name = s.nextLine();
        System.out.println("メールアドレスを入力してください");
        String mail = s.nextLine();
        
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
        
        AdminUser newAdminUser = new AdminUser(name, mail, adminCode);
        users.add(newAdminUser);
        
        System.out.println("登録完了");
        }
    
    // メールアドレスが既に登録されているか確認するメソッド
    public static void isEmailRegistered() {
        if(users)
    }
    // 登録されたユーザーを表示するメソッド
    public static void findUsers() {
        
    }
    
    
}



