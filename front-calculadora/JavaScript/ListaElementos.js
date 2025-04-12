// Nombre de la función corregido (tenías "listaElemetnos" con una 'm' faltante)
function listaElementos() {
  fetch("http://localhost:8080/elementos/tipos")
    .then((response) => response.json())
    .then((data) => {
      const lista = document.getElementById("elementosdb");
      lista.innerHTML = "<option value=''>--Selecciona--</option>";

      data.forEach((elemento) => {
        const option = document.createElement("option");
        option.value = elemento.id;
        option.textContent = elemento.elemento;
        lista.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("Error al obtener elementos:", error);
    });
}

// Corrección en el event listener (sin paréntesis al final)
window.addEventListener("DOMContentLoaded", listaElementos);
