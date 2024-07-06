// 要件：ユーザーを登録できる機能を作成します。

class User {
    // 名前とメールアドレスのプロパティを持ったコンストラクタを作成してください。
    consutoructor(name, mail){
        this.name = name;
        this.mail = mail;
    }
}

// ユーザー情報を保存する配列を作成してください。

// ユーザー情報を登録する関数を作成してください。
function registerUser() {
    // nameフィールドの値を取得してください
    let name = document.querySelector('#name').value;
    // emailフィールドの値を取得してください。
    let mail = document.querySelector('#mail');
    // 登録されているユーザーを取得してください。
    
    // メールアドレスの重複を確認してください。
    // 既に登録済みの場合、登録しようとしたメールアドレスをを含む重複している旨のメッセージを出力してください。
    // 未登録の場合はユーザー情報を配列に追加してください。    

    // 登録後にnameフィールドの値を削除してください
    document.querySelector('#name').value = "";
    // 登録後にemailフィールドの値を削除してください
    document.querySelector('#mail').value = "";
}

// 登録されたユーザー情報を1件ずつコンソール出力する関数を作成してください。
function findUser() {
    
}