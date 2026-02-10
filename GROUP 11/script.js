// Authentication and form handling logic

// Check if user is logged in on dashboard page
if (window.location.pathname.includes('dashboard.html')) {
    const isLoggedIn = localStorage.getItem('isLoggedIn');
    if (!isLoggedIn) {
        window.location.href = 'index.html';
    }
    
    // Update total registers count
    const users = JSON.parse(localStorage.getItem('users') || '[]');
    const totalRegistersElement = document.getElementById('totalRegisters');
    if (totalRegistersElement) {
        totalRegistersElement.textContent = users.length;
    }
    
    // Logout functionality
    const logoutBtn = document.getElementById('logoutBtn');
    if (logoutBtn) {
        logoutBtn.addEventListener('click', function(e) {
            e.preventDefault();
            localStorage.removeItem('isLoggedIn');
            localStorage.removeItem('currentUser');
            window.location.href = 'index.html';
        });
    }
}

// Redirect to dashboard if already logged in (on login/signup pages)
if ((window.location.pathname.includes('index.html') || window.location.pathname === '/') || window.location.pathname.includes('signup.html')) {
    const isLoggedIn = localStorage.getItem('isLoggedIn');
    if (isLoggedIn && !window.location.pathname.includes('signup.html')) {
        // Only redirect from login page, not signup
        if (window.location.pathname.includes('index.html') || window.location.pathname === '/') {
            // Uncomment below if you want auto-redirect
            // window.location.href = 'dashboard.html';
        }
    }
}

// Login Form Handler
const loginForm = document.getElementById('loginForm');
if (loginForm) {
    loginForm.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const errorMessage = document.getElementById('errorMessage');
        
        // Get users from localStorage
        const users = JSON.parse(localStorage.getItem('users') || '[]');
        
        // Find user
        const user = users.find(u => u.email === email && u.password === password);
        
        if (user) {
            localStorage.setItem('isLoggedIn', 'true');
            localStorage.setItem('currentUser', JSON.stringify(user));
            window.location.href = 'dashboard.html';
        } else {
            errorMessage.textContent = 'Invalid email or password';
            errorMessage.style.display = 'block';
        }
    });
}

// Signup Form Handler
const signupForm = document.getElementById('signupForm');
if (signupForm) {
    signupForm.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const email = document.getElementById('signupEmail').value;
        const password = document.getElementById('signupPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        const errorMessage = document.getElementById('errorMessage');
        
        // Validation
        if (password !== confirmPassword) {
            errorMessage.textContent = 'Passwords do not match';
            errorMessage.style.display = 'block';
            return;
        }
        
        if (password.length < 6) {
            errorMessage.textContent = 'Password must be at least 6 characters';
            errorMessage.style.display = 'block';
            return;
        }
        
        // Get existing users
        const users = JSON.parse(localStorage.getItem('users') || '[]');
        
        // Check if email already exists
        if (users.some(u => u.email === email)) {
            errorMessage.textContent = 'Email already registered';
            errorMessage.style.display = 'block';
            return;
        }
        
        // Add new user
        const newUser = {
            firstName,
            lastName,
            email,
            password
        };
        users.push(newUser);
        localStorage.setItem('users', JSON.stringify(users));
        
        // Show success and redirect
        alert('Account created successfully! Please login.');
        window.location.href = 'index.html';
    });
}