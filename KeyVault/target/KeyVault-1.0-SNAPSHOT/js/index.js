var ojoForm = document.querySelector(".imagenForm");
const inputContrasena = document.getElementById("inputContrasena");
let divProgreso = document.querySelector(".barraProgeso");
let parrafo = document.querySelector(".porcentajeProgreso");
let inputNombre = document.querySelector("#inputNombre");
const buttonGenerar = document.querySelector(".buttonGenerar");

function generarPasswordSeguro(longitud = 12) {
    const caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
    let password = "";
    
   
    const valoresAleatorios = new Uint32Array(longitud);
    
    // Llenamos el array con números criptográficamente seguros
    window.crypto.getRandomValues(valoresAleatorios);

    for (let i = 0; i < longitud; i++) {
        const indiceAleatorio = valoresAleatorios[i] % caracteres.length;
        password += caracteres.charAt(indiceAleatorio);
    }

    return password;
}

buttonGenerar.addEventListener("click", ()=> {
    console.log("hola");
    inputContrasena.value = generarPasswordSeguro();
    const eventoInput = new Event('input', { bubbles: true });
    
    inputContrasena.dispatchEvent(eventoInput);
    });


inputContrasena.addEventListener('input', (e) => {
    
    const valor = e.target.value;
    let criteriosCumplidos = 0;
    const totalCriterios = 5; 

    // 1. Criterio: Largo mínimo
    if (valor.length >= 12) criteriosCumplidos++;

    // 2. Criterio: Contiene mayúsculas
    if (valor !== valor.toLowerCase()) criteriosCumplidos++;

    // 3. Criterio: Contiene minúsculas
    if (valor !== valor.toUpperCase()) criteriosCumplidos++;

    // 4. Criterio: Contiene números
    if (/\d/.test(valor)) criteriosCumplidos++;

    // 5. Criterio: Contiene caracteres especiales (ej. @, \$, !, %, *, ?, &)
    if (/[@\$!%*?&]/.test(valor)) criteriosCumplidos++;

    
    // Calcular el porcentaje (de 0% a 100%)
    let porcentaje = (criteriosCumplidos / totalCriterios) * 100;
   
    if(valor.includes(inputNombre.value) || valor === inputNombre.value && porcenaje >= 30) porcentaje -= 30;
   
    divProgreso.style.width = `${porcentaje}%`;
    parrafo.textContent = `Porcenaje: ${porcentaje}%`;;
   
   
    if (porcentaje === 0) {
        divProgreso.style.backgroundColor = "transparent";
    } else if (porcentaje <= 50) {
        parrafo.style.color = "#ff4d4d"; 
        divProgreso.style.backgroundColor = "#ff4d4d"; 
    } else if (porcentaje < 100) {
        divProgreso.style.backgroundColor = "#ffcc00"; 
         parrafo.style.color = "#ffcc00";
    } else {
        divProgreso.style.backgroundColor = "#2ecc71";
          parrafo.style.color = "#2ecc71";
    }

});

ojoForm.addEventListener("click", () => {
  
    if (inputContrasena.type === 'password') {
        inputContrasena.type = 'text';
       
        ojoForm.src = "https://cdn-icons-png.flaticon.com/128/159/159604.png"; 
    } else {
       
        inputContrasena.type = 'password';
        
        ojoForm.src = "https://cdn-icons-png.flaticon.com/128/10812/10812267.png";
    }
});