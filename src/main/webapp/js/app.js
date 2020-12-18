const url = 'http://localhost:8080/project-1/';
const navBar = document.getElementById('navBar');
const welcomeNav = document.getElementById('welcomeNav');
const viewPendingNav = document.getElementById('viewPendingNav');
const addNav = document.getElementById('addNav');
const viewPastNav = document.getElementById('viewPastNav');
const logoutNav = document.getElementById('logoutNav');
const appView = document.getElementById('appView');

let userID = 0;
let userRole = 0;

document.getElementById('loginButton').addEventListener('click', login);
welcomeNav.addEventListener('click', goWelcome);
logoutNav.addEventListener('click', logout);

async function login() {
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

        if (userRole === 1) {
            navBar.setAttribute('style', 'display: block;');
            welcomeNav.setAttribute('style', 'display: block;');
            addNav.setAttribute('style', 'display: block;');
            viewPastNav.setAttribute('style', 'display: block;');
            logoutNav.setAttribute('style', 'display: block;')

            goWelcome();
        }
        
        else {
            navBar.setAttribute('style', 'display: block;');
            welcomeNav.setAttribute('style', 'display: block;');
            viewPendingNav.setAttribute('style', 'display: block;');
            logoutNav.setAttribute('style', 'display: block;')

            goWelcome();
        }
    }

    else {
        document.getElementById('body').innerHTML='<h1>It Fails!';
    }
}

function goWelcome() {
    window.location.hash = '#welcome';
    
    if (userRole === 1) {
        document.getElementById('appView').innerHTML = "<h1>Is Employee!</h1>";
    }

    else {
        document.getElementById('appView').innerHTML = "<h1>Is Manager!</h1>";
    }
}

function logout() {
    fetch(url + "logout", {
        method: "PUT",
        credentials:'include'});

    return;
}