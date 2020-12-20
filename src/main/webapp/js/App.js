const url = 'http://localhost:8080/project-1/';

export default class App {

    userType = 0;
    userId = 0;
    
    init() {
        let validLogin = false;
        
        this.renderLogin();

        document.getElementById('loginButton').onclick = this.login;       
    }

    async login() {
        let user = {
            username:document.getElementById('username').value,
            password:document.getElementById('password').value,
        };
    
        let response = await fetch(url + 'login', {
            method:"POST",
            body:JSON.stringify(user),
            credentials:'include'});
    
        if (response.status === 200) {
            let validUser = await response.json();
            this.userId = parseInt(validUser[0]);
            this.userType = parseInt(validUser[1]);
        }

        else {
            document.getElementById('appViewDiv').innerHTML='<h1>It Fails!</h1>';
        }
    }

    logout() {
        async function logout() {
            let response = await fetch('http://localhost:8080/project-1/logout', 
            {
                method: "PUT",
                credentials:'include'
            });
        
            if (response === 200) {
                return;
            }
        }
    }
    
    renderLogin() {
        let title = document.getElementById('appTitle');
        let appView = document.getElementById('appViewDiv');

        title.innerText = "ERS Reimbursement System - Login";

        appView.innerHTML = `<h3>ERS Reimbursement System <br><br>Login</h3>
        <input type="text" id="username" 
            placeholder="Enter your username">
        <br>
        <br>
        <input type="password" id="password" placeholder=
            "Enter your password">
        <br>
        <br>
        <button id='loginButton'>Login</button>`;     
    }

    renderEmployee() {
        document.getElementById('appViewDiv').innerHTML = '<h1>Test</h1>';
    }

    renderManager() {
        document.getElementById('appViewDiv').innerHTML = "<h1>Manager Logged In</h1>";
    }
}