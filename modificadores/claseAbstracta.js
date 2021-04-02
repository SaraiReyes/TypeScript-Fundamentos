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
var ClasePadre = /** @class */ (function () {
    function ClasePadre() {
    }
    ClasePadre.prototype.saludar = function (saludo) {
        return saludo;
    };
    return ClasePadre;
}());
var ClaseHijo = /** @class */ (function (_super) {
    __extends(ClaseHijo, _super);
    function ClaseHijo() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ClaseHijo.prototype.caminar = function () {
        console.log('caminando');
    };
    ClaseHijo.prototype.gatear = function () {
        console.log('gateando');
    };
    return ClaseHijo;
}(ClasePadre));
var ClaseOtro = /** @class */ (function (_super) {
    __extends(ClaseOtro, _super);
    function ClaseOtro() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ClaseOtro.prototype.caminar = function () {
        console.log('caminando');
    };
    ClaseOtro.prototype.gatear = function () {
        console.log('gateando');
    };
    return ClaseOtro;
}(ClasePadre));
