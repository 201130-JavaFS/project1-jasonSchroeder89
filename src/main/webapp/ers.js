const url = 'http://localhost:8080/project-1/';

const appNavBar = document.getElementById('appNavBar');
const welcomeNav = document.getElementById('welcomeNav');
const viewPendingNav = document.getElementById('viewPendingNav');
const addNav = document.getElementById('addNav');
const viewPastNav = document.getElementById('viewPastNav');
const logoutNav = document.getElementById('logoutNav');
const appViewDiv = document.getElementById('appViewDiv');
const loginButton = document.getElementById('loginButton');

let userID = 0;
let userRole = 0;

loginButton.onclick = login;
welcomeNav.onclick = welcome;
addNav.onclick = add;
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

            welcome();
        }
        
        else {
            appNavBar.setAttribute('style', 'display: block;');
            welcomeNav.setAttribute('style', 'display: block;');
            viewPendingNav.setAttribute('style', 'display: block;');
            logoutNav.setAttribute('style', 'display: block;')

            welcome();
        }
    }

    else {
        document.getElementById('appBody').innerHTML='<h1>It Fails!';
    }
}

function welcome() {
    document.title = "ERS - Welcome";
    
    if (userRole === 1) {
        appViewDiv.setAttribute('style', 'text-align: left;')
        appViewDiv.innerHTML = `<h1>Welcome to ERS Reiumbursement System!</h1>
            <h2>Add New Request</h2><h3>Click "Add New Request" 
            to create a new reimbursement request.</h3><h2>View Past Requests
            </h2><h3>Click "View Past Requests" to view your previous 
            reimbursement requests.</h3><h2>Logout</h2><h3>Click "Logout" to
            logout of the system</h3>`;
    }

    else {
        appViewDiv.setAttribute('style', 'text-align: left;')
        appViewDiv.innerHTML = `<h1>Welcome to ERS Reiumbursement System!</h1>
        <h2>View Pending Requests</h2><h3>Click "View Pending Requests" 
        to view and approve/deny all pending reimbursement requests.</h3>
        <h2>Logout</h2><h3>Click "Logout" to logout of the system</h3>`;
    }
}

async function add() {
    document.title = "ERS - Create Request";

    appViewDiv.innerHTML = `<h1>Create Reimbursement Request</h1>
    <div id = 'addForm' name = 'addForm' onsubmit = event.preventDefault();>
        <label for="expenseType">Expense Type: </label>
        <select id="expenseType" name="expenseType">
            <option value="1">LODGING</option>
            <option value="2">TRAVEL</option>
            <option value="3">FOOD</option>
            <option value="4">OTHER</option>
        </select>
        <br>
        <label for="tag1">Expense Amount($): </label>
        <input type="text" id="expenseAmount" name="expenseAmount" 
            placeholder="Dollars.Cents">
        <br>
        <label for="expenseComments">Comments: </label>
        <br>
        <textarea id='expenseComments' maxlenght="300" name="expenseCommentsArea" rows="10" 
            cols="30" placeholder="Comments for Finance Manager"></textarea>
        <br>
        <input id='submitButton'type='submit' value="Submit">
        <input id='resetButton' type='reset' value='Reset'>
    </div>
    <p id='requestStatus'></p>`;

    let status = document.getElementById('requestStatus');
    let expenseType = document.getElementById('expenseType');
    let expenseAmount = document.getElementById('expenseAmount');
    let expenseComments = document.getElementById('expenseComments');

    document.getElementById('resetButton').onclick = async () => {
        expenseType.value = "LODGING";
        expenseAmount.value = '';
        expenseComments.value = '';
        status.innerText = '';
    }
    
    document.getElementById('submitButton').onclick = async () => {
        let amount = document.getElementById('expenseAmount').value;
        if (amount == "") {
            alert("Expense Amount is required");
            return false;
        }

        else if (isNaN(amount) || amount <= 0.0) {
            alert('Expense Amount must be a valid numeric value greater than ' 
                + '"$0.00"');
            return false;
        }
        
        status.innerText = 'Staus: PROCESSING';

        let time = new Date();

        let timeStamp = ""  + time.getDate() + "/" 
        + (time.getMonth()+1)  + "/" 
        + time.getFullYear() + " @ "  
        + time.getHours() + ":"  
        + time.getMinutes() + ":" 
        + time.getSeconds();

        let reimbursement = {
            author : userID,
            time_submitted: timeStamp,
            type_id: document.getElementById('expenseType').value,
            reimb_amount: document.getElementById('expenseAmount').value,
            description: document.getElementById('expenseComments').value,
        }

        let response = await fetch(url + "add", {
            method:"POST",
            body:JSON.stringify(reimbursement),
            credentials:'include'});

        if (response.status === 200) {
            status.innerText = 'REQUEST SUBMITTED';
        }

        else {
            status.innerText = 'REQUEST FAILED';
        }
    }
}

async function logout() {
    let response = await fetch(url + "logout", {method: 'PUT',
        credentials:'include'});

    if (response.status === 200) {
        window.location.hash = "#login";
    
        appNavBar.setAttribute('style', 'display: none;');
        welcomeNav.setAttribute('style', 'display: none;');
        viewPendingNav.setAttribute('style', 'display: none;');
        addNav.setAttribute('style', 'display: none;');
        viewPastNav.setAttribute('style', 'display: none;');
        logoutNav.setAttribute('style', 'display: none;');

        appViewDiv.setAttribute('style', 'text-align: center;')
        appViewDiv.innerHTML = `<h3>ERS Reimbursement System<br>Login</h3>
        <input type="text" id="username" 
            placeholder="Enter your username">
        <br>
        <br>
        <input type="password" id="password" placeholder=
            "Enter your password">
        <br>
        <br>
        <button id='loginButton'>Login</button>`;

        document.title = "ERS - Login";
        document.getElementById('loginButton').addEventListener('click', login);        
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