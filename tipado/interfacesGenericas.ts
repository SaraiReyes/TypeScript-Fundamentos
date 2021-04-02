interface Interface<T=string>{
  nombre:T

}
let obj: Interface = { nombre: 'Misael' }

interface Interface1<T>{
  nombre:T

}
let obj1: Interface1<string> = { nombre: 'Misael' }
let obj2: Interface1<number> = { nombre: 25 }
