@PetStoreFuncionamiento
  Feature: Gestion de ordenes de la tienda de mascotas
    @crearOrden1
    Scenario Outline: Crear una nueva orden
      #post
      Given dado que estoy en la pagina
      When creo una orden con id<id>, petId<petId>, quantity<quantity>
      Then el codigo de estado de la respuesta debe ser codigo<codigo>
      And la respuesta debe contener el id<id>, petId<petId>, quantity<quantity>
      # nota debe ser el id menos de 10 Please correct the following validation errors and try again.
      #For 'orderId': Value must be less than 10.


      Examples:
        | id | petId   | quantity | codigo |
        | 7  | 2     | 3        | 200    |
        | 8  | 1     | 1        | 200    |
        | 9  | 1     | 1        | 200    |
        | 10  | 1     | 1        | 200    |

      #get
    @buscarOrden1
    Scenario Outline: Buscar una orden
          Given dado que estoy en la pagina a buscar
          When busco la orden con id<id>
          Then el codigo encontrado debe ser<codigoConsultado>


        Examples:
          |id | codigoConsultado |
          | 7 | 200    |
          | 8 | 200    |
          | 1000001 | 404    |
          | 11 | 404    |



