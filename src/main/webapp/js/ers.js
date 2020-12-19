import App from './App.js';
import Authenticator from './Authenticator.js';

let authenticator = new Authenticator;

while (true) {
    
    authenticator.login();
    
    let app = new App(authenticator.getUserType());

    app.render();

    authenticator.logout();
}