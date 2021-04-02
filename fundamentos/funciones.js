function suma(a, b) {
    return a + b;
}
//const resultado: number = suma(2, 3)
//console.log(resultado)
/**
 *
 *
 *    tipos de funcions y parametros
 *
 *
 */
/**
 *  Primera forma
 */
function mostrar() {
    console.log('Función 1');
}
/**
 * Segunda forma
 */
var mostrar2 = function () { console.log('Función 2'); };
//mostrar()
//mostrar2()
/**
 * Tipos de parámetros
 */
/**
 * parámetros opcionales
 */
var opciones = function (nombre, apellido, edad) {
    if (!edad) {
        console.log("su nombre es " + nombre + ", su apellido es " + apellido);
    }
    else
        console.log("su nombre es " + nombre + ", su apellido es " + apellido + " y su edad " + edad);
};
//opciones('Carmen', 'Pérez')
//opciones('Ana','Pérez',1)
/**
 * parámetros por defecto
 */
var defecto = function (nombre, apellido, edad) {
    if (edad === void 0) { edad = 20; }
    return "su nombre es " + nombre + ", su apellido es " + apellido + " y su edad " + edad;
};
//encaso de pasar él parámetro toma el valor que le das
//console.log(defecto('Juan', 'Juarez', 27))
//encaso de no pasar él parámetro toma el valor que tiene por defecto
//console.log(defecto('William', 'Juarez'))
/**
 * parámetros REST
 */
var rest = function (postre) {
    var frutas = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        frutas[_i - 1] = arguments[_i];
    }
    console.log("El postre es " + postre + " y tiene " + frutas);
};
//rest('postre1', 'manzana', 'pera')
//rest('postre1','manzana','pera','mandarina','fresa')
