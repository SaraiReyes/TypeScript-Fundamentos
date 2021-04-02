/** tipo de datos */
/** 
 * Ejecucuión de un archivo ts
 * 
 * 
 * tsc .\fundamentos\tipodatos.ts
 * node .\fundamentos\tipodatos.js
 * 
 * 
 */
/** 
 * Formas de declarar un variable 
 */
var variable1= 'Ana' // nunca usar este tipo de variable
let variable2:string = 'Rebeca'//este tipo de declaracion puede cabiar el valor de la variable mas adelante
const variable3:string = 'Rosa' //este tipo de variable no cambia su valor una vez declarada 
//puede tener comullas simples('') o dobles("")
/** 
 * tipo boolean  
 */
let si: boolean = true
let no: boolean = false
/** 
 * tipo number  
 */
let numero: number = 10
numero = 35

//console.log(numero)
/** 
 * tipo string  
 */
let nombre:string = 'Jessica'
let apellido: string = 'Suarez'
//console.log(nombre+apellido)
/** 
 * tipo Array  
 */
//Primera forma de crear un arreglo
let numeros: number[] = [1, 2, 3, 4, 5]
let nombres: string[] = ['Javier', 'Alma', 'Rocio']
//Primera forma de crear un arreglo
let coleccion1: Array<number> = [1, 2, 3, 4, 5]
let coleccion2: Array<string> = ['Javier', 'Alma', 'Rocio']

/** 
 * tipo Tupla  
 */
let tupla: [number, string, boolean]
tupla = [1, 'nombre', true]
//console.log(tupla[0])
