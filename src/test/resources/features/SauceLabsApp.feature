Feature: Carrito de compras mobile
  Background:
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria

  @Cart
  Scenario Outline: Agregar productos al carrito
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                      | UNIDADES |
      | Sauce Labs Backpack          | 1        |
      | Sauce Labs Onesie          | 1        |
      | Sauce Labs Onesie          | 2        |
      | Sauce Labs Bolt T-Shirt      | 1        |
      | Sauce Labs Bike Light        | 2        |