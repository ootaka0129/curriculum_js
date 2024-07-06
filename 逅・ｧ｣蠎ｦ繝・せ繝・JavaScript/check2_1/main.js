document.addEventListener('DOMContentLoaded', function() {
    // addTodoBtnの要素を取得してください。

    let addTodoBtn = document.querySelector('#addTodoBtn');
    let todoInput = document.querySelector('#todoInput');
    let todoList = document.querySelector('#todoList');

    // 追加ボタンが押下されたときのイベントを追加してください
    addTodoBtn.addEventListener('click', function(){
        let text = todoInput.value
        if(text === ''){
            alert('ToDoを入力してください');
        }

        let item = document.createElement('li');
        item.textContent = text.value;
        todoList.appendChild(todoInput);
        todoInput.value = '';

    })
    // その関数の中で以下の処理を追加してください
    //      処理1、inputが空になっていたら、alert()処理をして処理を終わらせてください。
    //            メッセージは"ToDoを入力してください"を出力してください                  
    //      処理2、todoItem内に入力された文字が追加されるようにしてください。

});