class Animal{
  nombre: string
  tamanio: number

  constructor(nombre_: string, tamanio_: number) {
    this.nombre = nombre_
    this.tamanio=tamanio_
  }

  moverse():void {
    console.log('Se esta moviendo')
  }

}

const animal1 = new Animal('Serpiente', 3)
animal1.moverse
animal1.nombre