class Padre1{
  protected nombre: string
  protected edad: number
  
  constructor(nombre_: string, edad_: number) {
    this.nombre = nombre_
    this.edad=edad_
    
  }

  mostrarNombre1() {
    console.log(this.nombre)
  }
}

class Hijo1 extends Padre1{
  apellido: string
  
  constructor(  _nombre: string, _edad: number,_apellido:string) {
    super(_nombre, _edad)
    this.apellido=_apellido
  }

  mostrarNombreHijo1(): void{
    console.log(this.nombre)
  }


}

const nuevoHijo12 = new Hijo1('Alan', 24, 'Muñoz')
nuevoHijo12.mostrarNombre1
nuevoHijo12.mostrarNombreHijo1