function showSignup() {
    document.getElementById("slider").style.transform = "translateX(-50%)";
}

function showLogin() {
    document.getElementById("slider").style.transform = "translateX(0)";
}

function login() {
    const email = document.getElementById("loginEmail").value;
    const password = document.getElementById("loginPassword").value;

    if (email === "" || password === "") {
        alert("Please fill in all fields");
    } else {
        alert("Login successful");
    }
}

function signup() {
    const firstName = document.getElementById("signupFirstName").value;
    const lastName = document.getElementById("signupLastName").value;
    const email = document.getElementById("signupEmail").value;
    const password = document.getElementById("signupPassword").value;
    const confirm = document.getElementById("signupConfirm").value;

    if (firstName === "" ||  lastName === "" || email === "" || password === "" || confirm === "") {
        alert("Please fill in all fields");
    } else if (password !== confirm) {
        alert("Passwords do not match");
    } else {
        alert("Signup successful (frontend only)");
        showLogin();
    }
}
