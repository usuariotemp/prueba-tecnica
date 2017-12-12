var agregarProductoDataProductosSeleccionados = function(idProducto, precio) {
    var dataProductosSeleccionados = sessionStorage.getItem("dataProductosSeleccionados");
    if (dataProductosSeleccionados == null) {
        dataProductosSeleccionados = "";
    }

    var dataValorPedido = sessionStorage.getItem("dataValorPedido");
    if (dataValorPedido == null) {
        dataValorPedido = "";
    }

    dataProductosSeleccionados = dataProductosSeleccionados + idProducto + '|';
    var nuevaDataValorPedido = Number(dataValorPedido) + precio;

    sessionStorage.setItem("dataProductosSeleccionados", dataProductosSeleccionados);
    sessionStorage.setItem("dataValorPedido", nuevaDataValorPedido.toString());

    $("#valorTotalPedido").html("<h4>" + nuevaDataValorPedido.toString() + "<h4>");
}

var removerProductoDataProductosSeleccionados = function(idProducto, precio) {
    var dataProductosSeleccionados = sessionStorage.getItem("dataProductosSeleccionados");
    var dataValorPedido = sessionStorage.getItem("dataValorPedido");
    
    var valorReemplazar = idProducto.toString() + "|";
    var nuevaDataProductosSeleccionados = dataProductosSeleccionados.replace(valorReemplazar, '');
    var nuevaDataValorPedido = Number(dataValorPedido) - precio;
    
    sessionStorage.setItem("dataProductosSeleccionados", nuevaDataProductosSeleccionados);
    sessionStorage.setItem("dataValorPedido", nuevaDataValorPedido.toString());

    $("#valorTotalPedido").html("<h4>" + nuevaDataValorPedido.toString() + "<h4>");
}

// Valida si un producto ya fue seleccionado; y si es así, no lo permite agregar de nuevo
var validarProductoHaSidoSeleccionado = function(idProducto) {
    var dataProductosSeleccionados = sessionStorage.getItem("dataProductosSeleccionados");
    if (dataProductosSeleccionados != null) {
        var idsProductosSeleccionados = dataProductosSeleccionados.split("|");
        
        var indice = $.inArray(idProducto.toString(), idsProductosSeleccionados);
        if (indice == -1) {  // el producto no ha sido seleccionado
            return false;
        } else {
            return true;  // el producto ya fue seleccionado
        }
   }
}

// Valida si la cantidad de productos seleccionados es mayor a 5
var validarCantidadProductosSeleccionadosExcedeLimite = function() {
    var dataProductosSeleccionados = sessionStorage.getItem("dataProductosSeleccionados");
    if (dataProductosSeleccionados != null) {
        var idsProductosSeleccionados = dataProductosSeleccionados.split("|");
        
        if ((idsProductosSeleccionados.length - 1) >= 5) {  // excede límite de 5 productos permitidos
            return true;
        }
   }

   return false;
}

// Permite agregar un producto a la lista de productos para comprar
var agregarProductoSeleccionado = function(idProducto, nombreProducto, precio) {
    var productoHaSidoSeleccionado = validarProductoHaSidoSeleccionado(idProducto);
    if (productoHaSidoSeleccionado) {
 	    $("#dialogoMensaje").html("<p>El producto ya fue seleccionado, intenta de nuevo con algún otro<p>");        
        $("#dialogo").modal("toggle");
    } else {
        var cantidadProductosSeleccionadosExcedeLimite = validarCantidadProductosSeleccionadosExcedeLimite();
        if (cantidadProductosSeleccionadosExcedeLimite) {
            $("#dialogoMensaje").html("<p>La cantidad de productos seleccionados excede el límite permitido (5 productos)<p>");        
            $("#dialogo").modal("toggle");
        } else {
            var itemListaProductosSeleccionados = '<li id="seleccionado.' + idProducto + '" class="list-group-item"><span><button onclick="removerProductoSeleccionado(' + idProducto + ',' + precio + ')" class="btn btn-default"><i class="glyphicon glyphicon-remove"></i></button></span><span> ' + nombreProducto + '</span></li>';
            
            $('#listaProductosSeleccionados').append(itemListaProductosSeleccionados);
        
            agregarProductoDataProductosSeleccionados(idProducto, precio);
        }
    }
}

// Permite remover un producto que ya fue seleccionado para comprar
var removerProductoSeleccionado = function(idProducto, precio) {
    $('#listaProductosSeleccionados').on('click','[id^=seleccionado]', function() {
        $(this).remove();
     });   

     removerProductoDataProductosSeleccionados(idProducto, precio);
}

$(document).ready(function () {
    // Filtrar la tabla de productos que se pueden comprar con el valor de la búsqueda
    $("#inputBusqueda").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#tablaProductos tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    // Cargar tabla de productos que se pueden comprar
    $("#listaTipoProducto a").on("click", function() {
        var idTipoProducto = $(this).attr('id');

        $.ajax({
            type: "GET",
            url: "/tuschirosapp/producto?tipo=" + idTipoProducto,
            success: function (result) {
                // Borrar la tabla de productos y reconstruirla después de filtrar por cada tipo de producto
                $("#tablaProductos").html("");

                $.each(result, function (i, producto) {
                    var filaTablaProductos = 
                        '<tr>' +
                            '<td><button onclick="agregarProductoSeleccionado(' + producto.id + ',\'' + producto.nombre + '\',' + producto.tipoProducto.precio + ')" class="btn btn-default"><i class="glyphicon glyphicon-shopping-cart"></i></button></td>' +
                            '<td>' + producto.nombre + '</td>' +
                            '<td>' + producto.tipoProducto.precio + '</td>' +
                        '</tr>';
                    $('#tablaProductos').append(filaTablaProductos);
                });
    
                $("#tablaProductos tr:odd").addClass("table-primary");
                $("#tablaProductos tr:even").addClass("table-secondary");
            },
            error: function (e) {
                alert("ERROR: ", e);
                console.log("ERROR: ", e);
            }
        });
    });

    $.ajax({
        type: "GET",
        url: "/tuschirosapp/tipoIdentificacion",
        success: function (result) {
            // Borrar el select de tipos de identificación y reconstruirlo al cargar página
            $("#tipoIdentificacion").html("");
            $('#tipoIdentificacion').append("<option value=''>Elija una opción</option>");
            
            $.each(result, function (i, tipoIdentificacion) {
                var opcionSelect = '<option value=' + tipoIdentificacion.id + '\'>' + tipoIdentificacion.nombre + '</option>';
                $('#tipoIdentificacion').append(opcionSelect);
            });
        },
        error: function (e) {
            alert("ERROR: ", e);
            console.log("ERROR: ", e);
        }
    });

    $("#newModalForm").validate({
        rules: {
          nombre: {
            required: true,
            minlength: 8
          },
          tipoIdentificacion: {
            required: true
          },
          identificacion: {
            required: true,
            minlength: 8
          }
        },
        messages: {
          nombre: {
            required: "Debe indicar un nombre",
            minlength: "El nombre debe contener por lo menos 8 caracteres"
          },
          tipoIdentificacion: {
            required: "Debe indicar su tipo de identificación"
          },
          identificacion: {
            required: "Debe proporcionar una identificación",
            minlength: "La identificación debe contener por lo menos 8 caracteres"
          }
        }
    });

    // Cargar los productos relacionados con "Camisas Formales" al cargar la página
    $("#1").trigger("click");

    sessionStorage.setItem("dataProductosSeleccionados", "");    
    sessionStorage.setItem("dataValorPedido", "");    
});
