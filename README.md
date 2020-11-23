# warehouse
Tarea curso springboot

# modelo de datos:
https://github.com/mokusan/warehouse/blob/master/modelo-warehouse-app.png

# crear fabricante:
{
    "nombre": "fabricante 1"
}

# crear producto 
{
    "idProducto": 1,
    "nombre": "producto 1",
    "precio": "105.9",
    "fabricante": {
        "idFabricante": 1,
        "nombre": "fabricante 1"
    }
}

# crear tienda
{
    "nombre": "tienda 1",
    "direccion": "calle, Santiago"
}

# crear inventario
{
    "producto": {
        "idProducto": 1,
        "nombre": "producto 1",
        "precio": "99.9",
        "fabricante": {
            "idFabricante": 1,
            "nombre": "fabricante 1"
        }
    },
    "cantidad": 5,
    "tienda": {
        "idTienda": 1,
        "nombre": "tienda 1",
        "direccion": "marin, Santiago"
    }
}
