import AbstractView from './AbstractView.js';

export default class LoginView extends AbstractView {
    constructor(params) {
        super(params);
        this.setTitle("ERS - Login");
    }

    getHtml() {
        return `
        <div align="center">
            <h3>ERS Reimbursement System <br><br>Login</h3>
            <form action="login" method="post">
                <input type="text" name="userId" placeholder="Enter your username">
                <br>
                <br>
                <input type="password" name="password" placeholder=
                    "Enter your password">
                <br>
                <br>
                <input type="submit" value="Login">
            </form>
        </div>
        `;
    }    
}