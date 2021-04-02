/**
*Interfaces para finciones
*
*/
interface General{
  (nomb: string,ap:string, edadg:number):void
  
}

let funcionGeneral1: General
funcionGeneral1 = function (nomb: string, ap: string, edadg: number): void{
  console.log(`Nombre: ${nomb} ${ap} edad: ${edadg}`)
}

funcionGeneral1('Ambar','Toledo',34)