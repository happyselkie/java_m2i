import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Exception.NotFoundException;
import org.example.Model.Command;
import org.example.Model.Product;
import org.example.Repositoriy.CommandRepository;
import org.example.Repositoriy.ProductRepository;
import org.example.Service.CommandService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;

public class CommandSteps {

    private Command command;
    private Product product;
    private final CommandRepository commandRepository = Mockito.mock(CommandRepository.class);
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final CommandService commandService =  new CommandService(commandRepository);

    @Given("Customer wants to make a command")
    public void customerWantsToMakeACommand() {
        command = new Command();
        product = new Product();
    }

    @When("Customer has command")
    public void customerHasCommand() {
        command.setId_command(42);
    }

    @And("Customer choose the product {string}")
    public void customerChooseTheProduct(String productName) {
        product.setName(productName);
        command.addProductQuantity(product, 1);
    }

    /************ ADD PRODUCT ************/
    @Then("The product is added in command")
    public void theProductIsAddedInCommand() {
        Mockito.when(commandRepository.findById(command.getId_command())).thenReturn(command);

        Command expectedCommand = commandService.addProductToCommand(product, command.getId_command());

        Assert.assertEquals(expectedCommand, command);
    }

    @And("An error is raised if the command to is not found")
    public void anErrorIsRaisedIfTheCommandToIsNotFound() {
        Command commandUnknown = new Command(0);

        Mockito.when(commandRepository.findById(command.getId_command())).thenReturn(commandUnknown);

        Assert.assertThrows(NotFoundException.class, () -> { commandService.addProductToCommand(product, commandUnknown.getId_command()); });
    }

    /************ REMOVE PRODUCT ************/
    @Then("The product is removed from command")
    public void theProductIsRemovedFromCommand() {
        Mockito.when(commandRepository.findById(command.getId_command())).thenReturn(command);

        Command expectedCommand = commandService.removeProductToCommand(product, command.getId_command());

        Assert.assertEquals(expectedCommand, command);
    }

    @And("An error is raised if the command from is not found")
    public void anErrorIsRaisedIfTheCommandFromIsNotFound() {
        Command commandUnknown = new Command(0);

        Mockito.when(commandRepository.findById(command.getId_command())).thenReturn(commandUnknown);

        Assert.assertThrows(NotFoundException.class, () -> {commandService.removeProductToCommand(product, commandUnknown.getId_command());});
    }

    @And("An error is raised if the product is not found")
    public void anErrorIsRaisedIfTheProductIsNotFound() {
        Product productUnknown = new Product();

        Mockito.when(commandRepository.findById(command.getId_command())).thenReturn(command);

        Assert.assertThrows(NotFoundException.class, () -> {commandService.removeProductToCommand(productUnknown, command.getId_command());});
    }

    /************ VALID COMMAND ************/
    @Then("Customer receive validation mail")
    public void customerReceiveValidationMail() {
        Mockito.when(commandRepository.update(command)).thenReturn(command);

        Assert.assertEquals(commandRepository.update(command), command);
    }



}
