document.addEventListener('DOMContentLoaded', () => {
  const loginForm = document.getElementById('loginForm');
  const togglePassword = document.getElementById('togglePassword');
  const passwordInput = document.getElementById('password');

  // Mostrar / Ocultar contraseña
  togglePassword.addEventListener('click', () => {
    const isPassword = passwordInput.getAttribute('type') === 'password';
    passwordInput.setAttribute('type', isPassword ? 'text' : 'password');
    togglePassword.classList.toggle('fa-eye');
    togglePassword.classList.toggle('fa-eye-slash');
  });

  // Manejo del Login
  loginForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const username = document.getElementById('username').value.trim();
    const password = passwordInput.value.trim();

    // Simulación de autenticación (más adelante conectaremos con Spring Boot API)
    if (username && password) {
      let role = 'CLIENTE';

      // Simulación rápida según el usuario ingresado
      if (username.includes('admin')) {
        role = 'ADMIN';
      } else if (username.includes('soporte')) {
        role = 'SOPORTE';
      }

      // Guardamos la sesión localmente
      localStorage.setItem('user', JSON.stringify({
        username: username,
        role: role
      }));

      // Redirigir al dashboard
      window.location.href = 'dashboard.html';
    }
  });
});