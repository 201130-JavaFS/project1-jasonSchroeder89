import LoginView from './LoginView.js';

let view = new LoginView();

// const state = {
//     LOGIN: 'login',
//     EMPLOYEE: 'employee',
//     MANAGER: 'manager'
// }

// class System {
//     constructor(state)
// }

// let currentState = state.LOGIN;

document.getElementById('body').innerHTML = view.getHtml();