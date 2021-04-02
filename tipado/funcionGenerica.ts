function funcion1(dato: string): string{
  return dato
}

console.log(funcion1('Nuevo dato'))
/** 
 * Funciones Genericas, es decir que recibe cualquier tipo de dato 
 */

function mostrarGenerica<T>(dato1: T):T {
  return dato1
}


console.log(mostrarGenerica('Nuevo dato'))
console.log(mostrarGenerica(24))
console.log(mostrarGenerica(true))

const d = mostrarGenerica(24)
d.toExponential