interface NuevaPersona{
  altura: number
  peso: number
  nombre?: string
  
}

function mostrarPersona(persona: NuevaPersona) {
  let mediaDePeso = persona.altura / persona.peso
  if (persona.nombre) {
    console.log(`${persona.nombre} tiene una media de ${mediaDePeso}`)
  } else {
    console.log(`Tiene una media de ${mediaDePeso}`)
  }    
  
}

let person = { altura: 122, peso: 80 }
mostrarPersona(person)
let person2 = { altura: 162, peso: 70 , nombre: 'Martín'}
mostrarPersona(person2)
