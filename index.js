const url = `https://localhost:8080/welcome`;
const registerLink = document.getElementById("register-link");
const logregBox = document.querySelector(".logreg-box");
const loginLink = document.querySelector(".login-link");
const postUrl = `/register?userName=Nikhil&userEmail=nikhilrawat00@gmail.com&userPassword=Rawat@123`;
const signIn = document.getElementById("sign-in");
const signUp = document.getElementById("sign-up");
console.log(signIn, signUp);
// swap between sign-in to sign-up form
registerLink.addEventListener('click', () => {
    logregBox.classList.add('active');
    registerLink.style.display = "none";
    loginLink.style.display = "flex";
});

loginLink.addEventListener('click', () => {
    logregBox.classList.remove('active');
    loginLink.style.display = "none";
    registerLink.style.display = "flex";
});

// 
async function login() {
    const email = document.getElementById("login-email").value;
    const password = document.getElementById("login-password").value;
    const endPoint = url + `/login?userEmail=${email}&password=${password}`;
    try {
        let response = await fetch(endPoint);
        let data = await response.json();
        console.log(data);
    } catch (e) {
        console.log(e);
    }
}

signIn.addEventListener("click", login);

