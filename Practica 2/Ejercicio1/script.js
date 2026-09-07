//Selecciono el formulario lo guardo dentro de una constante
const form = document.getElementById("formUsuario");


//Vamos a indicar que sucede luego de enviar el formulario
form.addEventListener("submit" , function(event){

    //evitamos que la pagina recargue
    event.preventDefault();


    //Guardamos los datos ingresados en variables
    let nombreIngresado = document.getElementById("inpNombre").value;
    let mailIngresado = document.getElementById("inpMail").value;
    let edadIngresado = document.getElementById("inpEdad").value;



    //Guardamos los datos en un objeto js
    const usuario = {
        nombre: nombreIngresado,
        mail: mailIngresado,
        edad: Number(edadIngresado)
    };


    //Genero una salida por consola para validar la creacion del objeto
    console.log("Objeto creado!" , usuario);

});
