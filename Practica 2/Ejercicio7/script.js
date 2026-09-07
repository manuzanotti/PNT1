const form = document.getElementById("formUsuario");
const pResultado = document.getElementById("resultado");

form.addEventListener("submit", function(event) {
    event.preventDefault();

    const nombreIngresado = document.getElementById("inpNombre").value;
    const mailIngresado = document.getElementById("inpMail").value;
    const edadIngresada = document.getElementById("inpEdad").value;

    const usuario = {
        nombre: nombreIngresado,
        email: mailIngresado,
        edad: Number(edadIngresada)
    };

    fetch("/api/usuarios", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    })
    .then(respuesta => {
        // Si el servidor responde con un status fuera del rango 200-299
        if (!respuesta.ok) {
            throw new Error("Los datos enviados son incorrectos");
        }
        return respuesta.json(); 
    })
    .then(datos => {
        // Mensaje cuando la operación es exitosa
        pResultado.textContent = datos.mensaje || "Operación realizada correctamente";
        pResultado.style.color = "green"; 
    })
    .catch(error => {
        // Mensaje cuando ocurre un error de red o de validación
        pResultado.textContent = error.message || "No fue posible conectar con el servidor";
        pResultado.style.color = "red";
    });
});