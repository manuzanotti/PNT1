
const form = document.getElementById("formUsuario");



form.addEventListener("submit" , function(event){


    event.preventDefault();


  
    let nombreIngresado = document.getElementById("inpNombre").value;
    let mailIngresado = document.getElementById("inpMail").value;
    let edadIngresado = document.getElementById("inpEdad").value;



  
    const usuario = {
        nombre: nombreIngresado,
        mail: mailIngresado,
        edad: Number(edadIngresado)
    };


  
    //Utilizamos fetch para preparar y enviar la peticion al servidor
    fetch("/api/usuarios", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    });
    


});
