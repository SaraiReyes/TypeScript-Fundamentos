class Animal1{
  private nombre: string
  private tamanio: number

  constructor(nombre_: string, tamanio_: number) {
    this.nombre = nombre_
    this.tamanio=tamanio_
  }

  moverse():void {
    console.log('Se esta moviendo')
  }

}

const animal12 = new Animal1('Serpiente', 3)
animal12.moverse

