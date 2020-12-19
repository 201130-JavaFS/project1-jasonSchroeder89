export default class Authenticator {
    userType = null;

    login() {
        this.render();
    }
    
    render() {
        document.getElementById('body').innerHTML = "<h1>It Works!</h1>";
    }

    getUserType() {
        return this.userType;
    }
}