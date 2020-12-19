import Authenticator from './Authenticator.js';
import App from './App.js';

let auth = new Authenticator();

auth.login();

let app = new App(auth.getUserType);

app.render();