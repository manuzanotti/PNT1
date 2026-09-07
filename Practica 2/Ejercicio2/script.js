
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


    //Genero una salida por consola para validar la creacion del objeto
    console.log("Objeto creado!" , usuario);


    //ahora vamos a usar JSON.stringify() para poder pasar nuestro objeto a un Json
    const usuarioJson = JSON.stringify(usuario);
   //Selecciono el parrafo que tengo con id msg para darle salida a mi Json y lo guardo en una constante.
    let salida = document.getElementById("msg");

    //Asigno el contendo a mi constante salida y la muestro.
    salida.textContent = "Esta es la salida del Json" + usuarioJson;
});
