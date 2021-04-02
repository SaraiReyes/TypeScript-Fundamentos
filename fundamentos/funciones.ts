function suma(a: number, b: number) {
  return a + b
  
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

function mostrar(): void{
  console.log('Función 1')
}

/** 
 * Segunda forma
 */
const mostrar2 = (): void => { console.log('Función 2') }

//mostrar()
//mostrar2()

/** 
 * Tipos de parámetros
 */

/** 
 * parámetros opcionales
 */

const opciones = (nombre: string, apellido: string, edad?: number) => {
  if (!edad) {
    console.log(`su nombre es ${nombre}, su apellido es ${apellido}`)
  }else 
  console.log(`su nombre es ${nombre}, su apellido es ${apellido} y su edad ${edad}`)
}

//opciones('Carmen', 'Pérez')
//opciones('Ana','Pérez',1)

/** 
 * parámetros por defecto
 */
const defecto = (nombre: string, apellido: string, edad: number=20) => {
  return `su nombre es ${nombre}, su apellido es ${apellido} y su edad ${edad}`
}
//encaso de pasar él parámetro toma el valor que le das
//console.log(defecto('Juan', 'Juarez', 27))
//encaso de no pasar él parámetro toma el valor que tiene por defecto
//console.log(defecto('William', 'Juarez'))
/** 
 * parámetros REST
 */
const rest = (postre:string, ...frutas:string[]): void => {
    console.log(`El postre es ${postre} y tiene ${frutas}`)
}

//rest('postre1', 'manzana', 'pera')
//rest('postre1','manzana','pera','mandarina','fresa')