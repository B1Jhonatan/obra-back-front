function calcular() {
  // Capturar los valores de los inputs
  const largo = parseFloat(document.getElementById("largo").value);
  const ancho = parseFloat(document.getElementById("ancho").value);
  const alto = parseFloat(document.getElementById("alto").value);
  const cantidad = parseFloat(document.getElementById("cantidad").value);

  // Validar que los valores sean números
  if (isNaN(largo) || isNaN(ancho) || isNaN(alto) || isNaN(cantidad)) {
    alert("Por favor ingresa valores numéricos.");
    return;
  }

  // Enviar la petición al backend
  fetch("http://localhost:8080/medidas/calcular", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      largo: largo,
      ancho: ancho,
      alto: alto,
      cantidad: cantidad,
    }),
  })
    .then((response) => response.json()) // Convertir la respuesta a texto
    .then((data) => {
      document.getElementById("resultadoArea").textContent = data.areaUnidad;
      document.getElementById("resultadoTodo").textContent = data.areaTotal;
    })
    .catch((error) => {
      console.error("Error al conectar con el backend:", error);
      alert("Error en la conexión con el servidor.");
    });
}
