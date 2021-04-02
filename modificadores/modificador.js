var Animal = /** @class */ (function () {
    function Animal(nombre_, tamanio_) {
        this.nombre = nombre_;
        this.tamanio = tamanio_;
    }
    Animal.prototype.moverse = function () {
        console.log('Se esta moviendo');
    };
    return Animal;
}());
