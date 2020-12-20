const url = 'http://localhost:8080/project-1/';
const appNavBar = document.getElementById('appNavBar');
const welcomeNav = document.getElementById('welcomeNav');
const viewPendingNav = document.getElementById('viewPendingNav');
const addNav = document.getElementById('addNav');
const viewPastNav = document.getElementById('viewPastNav');
const logoutNav = document.getElementById('logoutNav');
const appViewDiv = document.getElementById('appViewDiv');

let userID = 0;
let userRole = 0;

document.getElementById('loginButton').addEventListener('click', login);
welcomeNav.addEventListener('click', goWelcome);
logoutNav.onclick = logout;

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
            appNavBar.setAttribute('style', 'display: block;');
            welcomeNav.setAttribute('style', 'display: block;');
            addNav.setAttribute('style', 'display: block;');
            viewPastNav.setAttribute('style', 'display: block;');
            logoutNav.setAttribute('style', 'display: block;')

            goWelcome();
        }
        
        else {
            appNavBar.setAttribute('style', 'display: block;');
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

async function logout() {
    window.location.hash = "#login";
    
    appNavBar.setAttribute('style', 'display: none;');
    welcomeNav.setAttribute('style', 'display: none;');
    viewPendingNav.setAttribute('style', 'display: none;');
    addNav.setAttribute('style', 'display: none;');
    viewPastNav.setAttribute('style', 'display: none;');
    logoutNav.setAttribute('style', 'display: none;');

    appViewDiv.innerHTML = `<h3>ERS Reimbursement System <br><br>Login</h3>
    <input type="text" id="username" 
        placeholder="Enter your username">
    <br>
    <br>
    <input type="password" id="password" placeholder=
        "Enter your password">
    <br>
    <br>
    <button id='loginButton'>Login</button>`;
}

function goWelcome() {
    window.location.hash = '#welcome';
    
    if (userRole === 1) {
        appViewDiv.innerHTML = "<h1>Is Employee!</h1>";
    }

    else {
        appViewDiv.innerHTML = "<h1>Is Manager!</h1>";
    }
}

// function getContent(fragmentId, callback){

//     // lets do some custom content for each page of your website
//     var pages = {
//         home: "This is the Home page. Welcome to my site.",
//         about: "This page will describe what my site is about",
//         contact: "Contact me on this page if you have any questions"
//     };

//     // look up what fragment you are searching for in the object
//     callback( pages[fragmentId]);
// }

// function loadContent(){

//     var contentDiv = document.getElementById("app"),
//     fragmentId = location.hash.substr(1);

//     getContent(fragmentId, function (content) {
//         contentDiv.innerHTML = content;
//     });
// }

// if(!location.hash) {
//     location.hash = "#home";
// }

// loadContent();

// window.addEventListener("hashchange", loadContent)