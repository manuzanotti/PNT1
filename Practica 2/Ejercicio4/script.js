const form = document.getElementById("formLibro");

form.addEventListener("submit" , function(event){
    event.preventDefault();
    
    let tituloIngresado = document.getElementById("inpTitulo").value;
    let categoriaIngresado = document.getElementById("inpCategoria").value;
    let autorIngresado = document.getElementById("inpAutor").value;

    const libro = {
        titulo: tituloIngresado,
        categoria: categoriaIngresado,
        autor: autorIngresado
    };


    fetch("/api/libros", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(libro)
    });

});
