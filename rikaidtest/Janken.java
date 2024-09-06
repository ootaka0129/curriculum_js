package rikaidtest;

import java.util.Random;
import java.util.Scanner;

public class Janken {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
        System.out.println("じゃんけんゲーム！");
        System.out.println("選択肢: 0: グー, 1: チョキ, 2: パー");
        System.out.print("あなたの手を選んでください: ");
        
        
        int userChoice = scanner.nextInt();
        int computerChoice = random.nextInt(3);
        
        
        
        //ここから作成
        String[] choice = {"グー", "チョキ", "パー"};
        
        
        String win = "勝ち";
        String lose = "負け";
        String draw = "あいこ";
        
        //①引き分け②勝ち③負け
        
        if (userChoice == computerChoice) {
            System.out.println("コンピュータの手: " + choice[computerChoice]);
            System.out.println(draw);
            
        } else if ((userChoice == 0 && computerChoice == 1) ||  //グとチョキ
                   (userChoice == 1 && computerChoice == 2) || //チョキとパー
                   (userChoice == 2 && computerChoice == 0)) { //パーとグー
            System.out.println("コンピュータの手: " + choice[computerChoice]);
            System.out.println(win);
            
        } else {
            System.out.println("コンピュータの手: " + choice[computerChoice]);
            System.out.println(lose);
        }
        
        
        //ここまで
        scanner.close();
    }
}