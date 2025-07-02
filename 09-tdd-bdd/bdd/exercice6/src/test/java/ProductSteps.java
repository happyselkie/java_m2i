import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Model.Product;
import org.example.Model.User;
import org.example.Repositoriy.ProductRepository;
import org.example.Repositoriy.UserRepository;
import org.example.Service.ProductService;
import org.example.Service.UserService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;

public class ProductSteps {

    private Product product;
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final ProductService productService =  new ProductService(productRepository);

    @Given("Customer who wants to browse the product list")
    public void customerWantsToBrowseTheProductList() {
        product = new Product();
    }

    /************ SEARCH ************/
    @When("Customer puts {string} the search bar")
    public void customerPutsTheSearchBar(String search) {
        product.setName(search);
    }

    @Then("Customer receive a list of products corresponding to {string}")
    public void customerReceiveAListOfProductsCorrespondingTo(String search) {
        Mockito.when(productRepository.findByName(search)).thenReturn(List.of(product));
        Assert.assertEquals(productService.findByName(search), List.of(product));
    }

    /************ CATEGORY ************/
    @When("Customer choose {string} category")
    public void customerChooseCategory(String category) {
        product.setCategorie(category);
    }

    @Then("Customer receive a list of products corresponding to the {string} category")
    public void customerReceiveAListOfProductsCorrespondingToTheCategory(String category) {
        Mockito.when(productRepository.findByCategory(category)).thenReturn(List.of(product));
        Assert.assertEquals(productService.findByCategory(category), List.of(product));
    }


}
