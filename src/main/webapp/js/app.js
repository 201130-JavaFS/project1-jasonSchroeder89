const url = 'http://localhost:8080/project-1/';
const navBar = document.getElementById('navBar');
const welcomeNav = document.getElementById('welcomeNav');
const viewAllNav = document.getElementById('viewAllNav');
const addNav = document.getElementById('addNav');
const viewPastNav = document.getElementById('viewPastNav');
const logoutNav = document.getElementById('logoutNav');
const appView = document.getElementById('appView');

document.getElementById('loginButton').addEventListener('click', login);
welcomeNav.addEventListener('click', goWelcome);
logoutNav.addEventListener('click', logout);

async function login() {
    let user = {
        username:document.getElementById('username').value,
        password:document.getElementById('password').value
    }

    let response = await fetch(url + "login", {
        method:"POST",
        body:JSON.stringify(user),
        credentials:'include'});

    if (response.status === 200) {
        navBar.setAttribute('style', 'display: block;');
        welcomeNav.setAttribute('style', 'display: block;');
        addNav.setAttribute('style', 'display: block;');
        viewPastNav.setAttribute('style', 'display: block;');
        logoutNav.setAttribute('style', 'display: block;')

        goWelcome();
    }

    else {
        document.getElementById('body').innerHTML='<h1>It Fails!';
    }
}

function goWelcome() {
    window.location.hash = '#welcome';
    document.getElementById('appView').innerHTML = "<h1>It Works Too!</h1>";
}

async function logout() {
    let response = await fetch(url + "logout", {
        method: "PUT",
        credentials:'include'});
}