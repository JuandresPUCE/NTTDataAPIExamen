package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {
    //instanciar la clase

    @Steps
    PetStoreStep petStoreStep;

    @Given("dado que estoy en la pagina")
    public void dadoQueEstoyEnLaPagina() {
    }

    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        petStoreStep.crearOrden(id, petId, quantity);


    }

    @Then("el codigo de estado de la respuesta debe ser codigo{int}")
    public void elCodigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        petStoreStep.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id{int}, petId{int}, quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Order order = petStoreStep.obtenerRespuestaOrder();
        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(petId, order.getPetId());
        assertEquals(quantity, order.getQuantity());


    }

    @Given("dado que estoy en la pagina a buscar")
    public void dadoQueEstoyEnLaPaginaABuscar() {
    }

    @When("busco la orden con id{int}")
    public void buscoLaOrdenConIdId(int id) {
        petStoreStep.consultarOrdenID(id);
    }

    @Then("el codigo encontrado debe ser{int}")
    public void elCodigoEncontradoDebeSerCodigo(int codigo) {
        petStoreStep.obtenerCodigoRespuesta();
        assertEquals("El código de respuesta no es el esperado", codigo, petStoreStep.obtenerCodigoRespuesta());


    }
}
