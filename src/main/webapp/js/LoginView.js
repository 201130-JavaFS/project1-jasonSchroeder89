import AbstractView from './AbstractView.js';

export default class LoginView extends AbstractView {
    constructor(params) {
        super(params);
        this.setTitle("ERS - Login");
    }

    displayHTML() {
        document.getElementById('app').innerHTML = 
        `<div align="center">
            <h3>ERS Reimbursement System <br><br>Login</h3>
                <input type="text" id="username" 
                    placeholder="Enter your username">
                <br>
                <br>
                <input type="password" id="password" placeholder=
                    "Enter your password">
                <br>
                <br>
                <button id='loginButton'>Login</button>
        </div>`;
    }
}