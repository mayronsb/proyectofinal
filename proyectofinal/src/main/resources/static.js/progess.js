// progress.js

// Esta función se llama cuando se presiona el botón "Agendar Cita"
function agendarCita() {
    // Realizar acciones de la fase 1: Información Personal
    mostrarFase("Información Personal", "green");

    // Simular un retraso para la fase 2: Confirmación (puedes personalizar según tus necesidades)
    setTimeout(function () {
        // Realizar acciones de la fase 2: Confirmación
        mostrarFase("Confirmación", "yellow");

        // Simular otro retraso para la fase 3: Finalización
        setTimeout(function () {
            // Realizar acciones de la fase 3: Finalización
            mostrarFase("Finalización", "blue");
        }, 2000); // Retraso de 2 segundos para la fase 3
    }, 2000); // Retraso de 2 segundos para la fase 2
}

// Función para mostrar la fase actual
function mostrarFase(fase, color) {
    console.log("Fase actual: " + fase);

    // Aquí puedes realizar acciones visuales, como cambiar colores o mostrar información al usuario
    // Por ejemplo, podrías actualizar una barra de progreso o cambiar el color de un elemento en la página
}

// Puedes agregar más funciones y personalizar según tus necesidades
