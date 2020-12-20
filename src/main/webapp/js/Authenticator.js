export default class Authenticator {
    constructor() {
        this.userType = '';
        this.userId = '';
    }

    init() {
        this.render();
        
        document.getElementById('loginButton').onclick = this.login;
    }

    getUserType() {
        return this.userType;
    }

    getUserId() {
        return this.userId;
    }

    async login() {
        let user = {
            username:document.getElementById('username').value,
            password:document.getElementById('password').value,
        };
    
        let response = await fetch('http://localhost:8080/project-1/login', {
            method:"POST",
            body:JSON.stringify(user),
            credentials:'include'});
    
        if (response.status === 200) {
            let validUser = await response.json();
            this.userId = validUser[0];
            this.userType = validUser[1];
            
            return true;
        }

        else {
            document.getElementById('appViewDiv').innerHTML='<h1>It Fails!</h1>';
            return false;
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
    
    render() {
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
}