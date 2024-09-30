package com.everis.base;

import com.everis.base.models.Order;

//import static net.serenitybdd.rest.RestRequests.given;
import static io.restassured.RestAssured.given;

public class PetStoreStep {
    private String URL_BASE = "https://petstore.swagger.io/v2/";
    private int codigoRespuesta;
    private Order respuestaOrder;

    public void crearOrden(int id, int petId, int quantity){

        Order nuevaOrden = new Order(id,petId, quantity);
        //metodo post
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                //.log()
                //.all()
                .header("Content-Type", "application/json")
                .body(nuevaOrden)
                .when()
                .post("store/order")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();
        //metodo get
        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("store/order/" + id)
                .as(Order.class);
        System.out.println("ID creado: " + respuestaOrder.getId());
        System.out.println("Pet ID creado: " + respuestaOrder.getPetId());
        System.out.println("Quantity creado: " + respuestaOrder.getQuantity());

    }
    public void validarCodigoRespuesta(int codigoEsperdo){
        if (codigoRespuesta != codigoEsperdo){
            throw new AssertionError("El codigo de respuesta no es correcto"+ codigoEsperdo + "cod obtenido" + codigoRespuesta);
        }


    }
    public Order obtenerRespuestaOrder(){
        return respuestaOrder;
    }

    public void consultarOrdenID(int id) {
        // Realizar el GET y capturar el código de estado
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .when()
                .get("store/order/" + id)
                .then()
                .extract()
                .statusCode();

        // Si el código de estado es 200, extraer la orden
        if (codigoRespuesta == 200) {
            respuestaOrder = given()
                    .baseUri(URL_BASE)
                    .when()
                    .get("store/order/" + id)
                    .as(Order.class);

            // Imprimir solo el ID de la orden
            System.out.println("ID orden: " + respuestaOrder.getId());
        } else {
            // Si no es 200, manejar el error adecuadamente
            System.out.println("Error: No se pudo obtener la orden. Código de respuesta: " + codigoRespuesta);
        }
    }

    public int obtenerCodigoRespuesta() {
        return codigoRespuesta; // Devuelve el código de estado de la última respuesta
    }

}
