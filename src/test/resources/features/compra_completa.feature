Feature: Flujo de compra completo como invitado en OpenCart

  @e2e @smoke @opencart @compra
  Scenario Outline: Comprar dos productos como invitado hasta la confirmacion del pedido
    Given el cliente abre la tienda OpenCart
    When agrega al carrito el producto "<producto_1>"
    And agrega al carrito el producto "<producto_2>"
    And visualiza el carrito de compras
    And inicia el checkout como invitado
    And completa los datos de facturacion con:

      | nombre | apellido   |      correo              | telefono   | direccion        | ciudad    | codigo_postal | pais          | region  |
      | Jeison | Monterrosa | prueba.guest@example.com | 3001234567 | 123 Calle Prueba | Cartagena |    130001     | Colombia      | Bolivar |

    And continua con el metodo de envio por defecto
    And acepta los terminos y condiciones y continua con el metodo de pago
    And confirma el pedido
    Then debe ver el mensaje de confirmacion "Your order has been placed!"

    Examples:
      | producto_1 | producto_2 |
      | MacBook    | iPhone     |