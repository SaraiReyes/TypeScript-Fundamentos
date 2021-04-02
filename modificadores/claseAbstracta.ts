abstract class ClasePadre{
  abstract caminar(): void
  abstract gatear(): void
  
  saludar(saludo: string):string {
        return saludo
  }
}

class ClaseHijo extends ClasePadre{
  caminar(): void{
    console.log('caminando')
  }
  gatear():void {
    console.log('gateando')
  }

}

class ClaseOtro extends ClasePadre{
  caminar(): void{
    console.log('caminando')
  }
  gatear():void {
    console.log('gateando')
  }

}