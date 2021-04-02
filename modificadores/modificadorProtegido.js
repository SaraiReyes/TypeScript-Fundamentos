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
var Padre1 = /** @class */ (function () {
    function Padre1(nombre_, edad_) {
        this.nombre = nombre_;
        this.edad = edad_;
    }
    Padre1.prototype.mostrarNombre1 = function () {
        console.log(this.nombre);
    };
    return Padre1;
}());
var Hijo1 = /** @class */ (function (_super) {
    __extends(Hijo1, _super);
    function Hijo1(_nombre, _edad, _apellido) {
        var _this = _super.call(this, _nombre, _edad) || this;
        _this.apellido = _apellido;
        return _this;
    }
    Hijo1.prototype.mostrarNombreHijo1 = function () {
        console.log(this.nombre);
    };
    return Hijo1;
}(Padre1));
var nuevoHijo12 = new Hijo1('Alan', 24, 'Muñoz');
nuevoHijo12.mostrarNombre1;
nuevoHijo12.mostrarNombreHijo1;
