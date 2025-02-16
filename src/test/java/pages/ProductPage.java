import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class ProductPage extends BaseClass {

    // Naslov proizvoda - Tražimo Samsung
    @FindBy(xpath = "//h1[contains(@class, 'text-sm') and contains(text(), 'Samsung')]")
    public WebElement productTitle;

    // Dugme za dodavanje u korpu
    @FindBy(xpath = "//button[contains(@class, 'p-button') and not(contains(@disabled, 'disabled'))]")
    public WebElement addToCartButton;

    // Polje za pretragu proizvoda (id search)
    @FindBy(id = "search")
    public WebElement searchField;

    public ProductPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    // Metoda za preuzimanje naziva proizvoda
    public String getProductTitle() {
        return productTitle.getText(); // Vraća naziv proizvoda
    }

    // Metoda za klik na dugme "Add to Cart"
    public void clickAddToCart() {
        click(addToCartButton); // Klik na dugme za dodavanje u korpu
    }

    // Metoda za pretragu proizvoda po nazivu
    public void searchForProduct(String productName) {
        sendKeys(searchField, productName); // Unosi naziv proizvoda u pretragu
    }
}
