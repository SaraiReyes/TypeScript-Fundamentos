var Animal1 = /** @class */ (function () {
    function Animal1(nombre_, tamanio_) {
        this.nombre = nombre_;
        this.tamanio = tamanio_;
    }
    Animal1.prototype.moverse = function () {
        console.log('Se esta moviendo');
    };
    return Animal1;
}());
var animal = new Animal1('Serpiente', 3);
animal.moverse;
