interface Person{
  nombre: string

}

function caminarA(persona:Person): void {
  console.log('La persona '+persona.nombre+' esta caminando')  
}

let nueva_persona = { nombre: 'Miguel' }
caminarA(nueva_persona)