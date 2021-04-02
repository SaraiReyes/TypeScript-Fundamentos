function mostrarPersona(persona) {
    var mediaDePeso = persona.altura / persona.peso;
    if (persona.nombre) {
        console.log(persona.nombre + " tiene una media de " + mediaDePeso);
    }
    else {
        console.log("Tiene una media de " + mediaDePeso);
    }
}
var person = { altura: 122, peso: 80 };
mostrarPersona(person);
var person2 = { altura: 162, peso: 70, nombre: 'Martín' };
mostrarPersona(person2);
