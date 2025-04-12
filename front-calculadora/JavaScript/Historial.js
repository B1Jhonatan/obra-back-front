function obtenerFiguras() {
  fetch("http://localhost:8080/medidas/historial")
    .then((response) => response.json()) // Convertir respuesta a JSON
    .then((data) => {
      const historial = document.getElementById("historial");
      historial.innerHTML = ""; // Limpiar la tabla antes de agregar elementos

      if (data.length === 0) {
        historial.innerHTML =
          "<tr><td colspan='6'>No hay figuras guardadas.</td></tr>";
        return;
      }

      data.forEach((figura) => {
        const fila = document.createElement("tr");
        fila.innerHTML = `
                    <td>${figura.largo}</td>
                    <td>${figura.ancho}</td>
                    <td>${figura.alto}</td>
                    <td>${figura.cantidad}</td>
                    <td>${figura.resultadoArea}</td>
                    <td>${figura.resultadoTodo}</td>
                `;
        historial.appendChild(fila);
      });
    })
    .catch((error) => {
      console.error("Error al obtener figuras:", error);
      document.getElementById("historial").innerHTML =
        "<tr><td colspan='6'>Error al cargar datos.</td></tr>";
    });
}

// Llamar a la función cuando la página cargue
document.addEventListener("DOMContentLoaded", obtenerFiguras);
