let permiso: boolean = true

class Persona{
  public nombre: string
  
  constructor(nombre:string) {
    this.nombre = nombre   
  }

  get  getNombre(): string{
    return this.nombre
  }
  set setNombre(nombre: string) {    
    if (permiso) {
      this.nombre = nombre
    }
    else {
      console.log('No tienes permiso')
    }
    
  }

}

const objeto = new Persona('Ana')
console.log(objeto.getNombre)
objeto.setNombre = 'Rosa'
console.log(objeto.getNombre)