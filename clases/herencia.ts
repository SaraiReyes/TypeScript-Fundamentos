class Padre{
  nombre: string
  edad: number
  
  constructor(nombre_: string, edad_: number) {
    this.nombre = nombre_
    this.edad=edad_
    
  }

  mostrarNombre() {
    console.log(this.nombre)
  }
}

class Hijo extends Padre{
  apellido: string
  
  constructor(  _nombre: string, _edad: number,_apellido:string) {
    super(_nombre, _edad)
    this.apellido=_apellido
  }

  mostrarNombreHijo() {
    console.log(this.nombre)
  }


}

const nuevoHijo = new Hijo('Alan', 24, 'Muñoz')
nuevoHijo.mostrarNombre
nuevoHijo.mostrarNombreHijo