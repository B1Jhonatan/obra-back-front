function guardar() {
  const elemento = "columnas";
  const elemento3D = document.getElementById("elemento").value;
  const largo = parseFloat(document.getElementById("largo").value);
  const ancho = parseFloat(document.getElementById("ancho").value);
  const alto = parseFloat(document.getElementById("alto").value);
  const cantidad = parseFloat(document.getElementById("cantidad").value);
  const resultadoArea = document.getElementById("resultadoArea").textContent;
  const resultadoTodo = document.getElementById("resultadoTodo").textContent;

  fetch("http://localhost:8080/elementos/guardar", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      elemento: elemento,
      elementos3D: [
        {
          elemento3D: elemento3D,
          cantidad: cantidad,
          medidas: {
            largo: largo,
            ancho: ancho,
            alto: alto,
          },
          areas: {
            areaUnidad: resultadoArea,
            areaTotal: resultadoTodo,
          },
        },
      ],
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      alert("Datos guardados correctamente.");
    })
    .catch((error) => {
      console.error("Error al guardar datos:", error);
      alert("Error al guardar datos.");
    });
}
