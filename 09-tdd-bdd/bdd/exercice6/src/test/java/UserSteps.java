import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Exception.AlreadyExisteException;
import org.example.Model.User;
import org.example.Repositoriy.UserRepository;
import org.example.Service.UserService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;

public class UserSteps {

    private User user;
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService =  new UserService(userRepository);

    @Given("Customer {string} who wants to create an account to command")
    public void whoWantsToCreateAnAccountToCommand(String customerName) {
        user = new User();
    }

    @When("Customer register email : {string}, username : {string} and password : {string}")
    public void CustomerRegisterEmailUsernameAndPassword(String email, String username, String password) {
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
    }

    @Then("Customer receive an confirmation email")
    public void customerReceiveAnConfirmationEmail() {
        String confirmationMail = userService.register(user);
        Assert.assertEquals("user Register! \n"+user, confirmationMail);
    }

    @And("Check if customer already exist and raise an error if it does")
    public void checkIfCustomerAlreadyExistAndRaiseAnErrorIfItDoes() {
        Mockito.when(userRepository.findByName("cortana")).thenReturn(List.of(user));
        Assert.assertThrows(AlreadyExisteException.class, () -> { userService.register(user); });
    }




}
