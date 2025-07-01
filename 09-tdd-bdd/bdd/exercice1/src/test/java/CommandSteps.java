import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.junit.Assert;

import java.util.List;

public class CommandSteps {

    private Command command;

    @Given("Customer {string} who want to command for someone")
    public void customerWhoWantToCommandForSomeone(String customerName) {
        command = new Command();
        command.setFrom(customerName);
    }

    @When("a command is make for someone")
    public void aCommandIsMakeForSomeone() {
        command.setTo("Tata");
    }

    @Then("there is no product in the Command")
    public void thereIsNoProductInTheCommand() {
        Assert.assertTrue(command.getProducts().isEmpty());
    }

    @Then("there is two products in the Command")
    public void thereIsTwoProductsInTheCommand() {
        List<String> products = command.getProducts();
        products.add("one");
        products.add("two");
        command.setProducts(products);
    }

    @And("the command comes from Customer {string}")
    public void theCommandComesFromCustomer(String customerName) {
        Assert.assertEquals(customerName, command.getFrom());
    }

    @And("the command has two products")
    public void theCommandHasTwoProducts() {
        Assert.assertEquals(command.getProducts().size(),2);
    }

}
