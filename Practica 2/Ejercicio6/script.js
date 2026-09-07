
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
    .then(respuesta => respuesta.json()) // Convertimos la respuesta del servidor a JS
    .then(datos => {
        // modificamos el texto contenido en presult
        pResultado.textContent = datos.mensaje;
        pResultado.style.color = "green";  //Le asignamos un color
    })

});