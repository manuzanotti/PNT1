
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
  
        if (!respuesta.ok) {
            throw new Error("Los datos enviados son incorrectos o el servidor rechazó la solicitud");
        }
        return respuesta.json(); 
    })
    .then(datos => {
        
        pResultado.textContent = datos.mensaje || "Operación realizada correctamente";
        pResultado.style.color = "green";
    })
    .catch(error => {
        // Capturamos y devolvemos el error en caso de existir
        pResultado.textContent = error.message || "No fue posible conectar con el servidor";
        pResultado.style.color = "red";
    });
});