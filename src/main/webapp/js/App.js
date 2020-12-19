import Authenticator from './Authenticator';

export default class App {
    constructor(userType) {
        this.userType = userType;        
    }

    render(userType) {
        switch(userType) {
            case 1:
                document.getElementById('app').innerHTML = "Employee Logged In";
                break;

            case 2:
                document.getElementById('app').innerHTML = "Manager Logged In";
                break;

            default:
                break;
        }
    }
}