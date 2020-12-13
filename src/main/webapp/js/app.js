import LoginView from './LoginView.js';

const url = 'http://localhost:8080/project-1/';

let view = new LoginView();

document.getElementById('body').innerHTML = view.getHtml();

document.getElementById('loginButton').addEventListener('click', login);
//document.getElementById('addExpenseForm').addEventListener('click', addExpense);

async function login() {
    let user = {
        username:document.getElementById('username').value,
        password:document.getElementById('password').value
    }

    let response = await fetch(url + "login", {
        method:"POST",
        body:JSON.stringify(user),
        credentials:'include'});

    if (response.status === 200) {
        document.getElementById('body').innerHTML='<h1>It Works!';
    }

    else {
        document.getElementById('body').innerHTML='<h1>It Fails!';
    }
}