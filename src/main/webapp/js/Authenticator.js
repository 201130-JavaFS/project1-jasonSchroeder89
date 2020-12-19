export default class Authenticator {
    constructor() {
        this.userType = '';
    }

    getUserType() {
        return this.userType;
    }

    login() {
        this.render();
        
        let user = {
            username:document.getElementById('username').value,
            password:document.getElementById('password').value,
        };
    
        let response = await fetch(url + "login", {
            method:"POST",
            body:JSON.stringify(user),
            credentials:'include'});
    
        if (response.status === 200) {
            let validUser = await response.json();
            userID = validUser[0];
            userRole = validUser[1];
        }

        else {
            document.getElementById('body').innerHTML='<h1>It Fails!';
        }
    }

    logout() {

    }
    
    render() {
        let title = document.getElementById('appTitle');
        let body = document.getElementById('appBody');

        title.innerText = "ERS Reimbursement System - Login";

        let loginForm = document.createElement('div');
        let loginFragment = document.createDocumentFragment();
        
        loginForm.appendChild(loginFragment);

        body.appendChild(loginForm);
    }
}