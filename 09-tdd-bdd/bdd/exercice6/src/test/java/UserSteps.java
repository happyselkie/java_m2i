import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Exception.AlreadyExisteException;
import org.example.Exception.NotFoundException;
import org.example.Exception.WrongPasswordException;
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

    @Given("Customer {string} who wants to get an account to command")
    public void whoWantsToGetAnAccountToCommand(String customerName) {
        user = new User();
    }

    /************ REGISTER ************/
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

    @And("Check if customer {string} already exist and raise an error if it does")
    public void checkIfCustomerAlreadyExistAndRaiseAnErrorIfItDoes(String username) {
        Mockito.when(userRepository.findByName(username)).thenReturn(List.of(user));
        Assert.assertThrows(AlreadyExisteException.class, () -> { userService.register(user); });
    }

    /************ LOG IN ************/
    @When("Customer inputs username : {string} and password : {string}")
    public void CustomerInputsUsernameAndPassword(String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
    }

    @Then("Customer {string} is redirect to homepage if success")
    public void customerIsRedirectToHomepageOnSucess(String username) {
        Mockito.when(userRepository.findByName(username)).thenReturn(List.of(user));
        String confirmation = userService.connection(user);
        Assert.assertEquals("user is Log:"+user, confirmation);
    }

    @And("Customer {string} gets an error if not register")
    public void customerGetsAnErrorIfNotRegister(String username) {
        User newUser = new User();
        newUser.setUsername("Toto");
        Mockito.when(userRepository.findByName(username)).thenReturn(List.of(user));
        Assert.assertThrows(NotFoundException.class, () -> { userService.connection(newUser); });
    }

    @And("Customer {string} gets an error if wrong password")
    public void customerGetsAnErrorIfWrongPassword(String username) {
        User newUser = new User();
        newUser.setUsername(username);
        Mockito.when(userRepository.findByName(username)).thenReturn(List.of(user));
        newUser.setPassword("wrong");
        Assert.assertThrows(WrongPasswordException.class, () -> { userService.connection(newUser); });
    }



}
