var permiso = true;
var Persona = /** @class */ (function () {
    function Persona(nombre) {
        this.nombre = nombre;
    }
    Object.defineProperty(Persona.prototype, "getNombre", {
        get: function () {
            return this.nombre;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Persona.prototype, "setNombre", {
        set: function (nombre) {
            if (permiso) {
                this.nombre = nombre;
            }
            else {
                console.log('No tienes permiso');
            }
        },
        enumerable: false,
        configurable: true
    });
    return Persona;
}());
var objeto = new Persona('Ana');
console.log(objeto.getNombre);
objeto.setNombre = 'Rosa';
console.log(objeto.getNombre);
