var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Padre = /** @class */ (function () {
    function Padre(nombre_, edad_) {
        this.nombre = nombre_;
        this.edad = edad_;
    }
    Padre.prototype.mostrarNombre = function () {
        console.log(this.nombre);
    };
    return Padre;
}());
var Hijo = /** @class */ (function (_super) {
    __extends(Hijo, _super);
    function Hijo(_nombre, _edad, _apellido) {
        var _this = _super.call(this, _nombre, _edad) || this;
        _this.apellido = _apellido;
        return _this;
    }
    Hijo.prototype.mostrarNombreHijo = function () {
        console.log(this.nombre);
    };
    return Hijo;
}(Padre));
var nuevoHijo = new Hijo('Alan', 24, 'Muñoz');
nuevoHijo.mostrarNombre;
nuevoHijo.mostrarNombreHijo;
