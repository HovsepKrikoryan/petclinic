import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EditPetPageTest extends BaseTest {

    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
        webApp.components().mainMenu().clickFindOwnersLink();
        webApp.findOwnersPage().enterLastName("Ivanov");
        webApp.findOwnersPage().clickFindOwnerButton();
        webApp.ownerInformationPage().clickEditPet();
    }

    @Test
    @Tag("Rossen")
    @DisplayName("PC-12: Can edit pet name")
    public void canEditPetName(){

        webApp.editPetPage().type("Tosho");
        webApp.editPetPage().clickUpdateButton();
        webApp.editPetPage().verifyPetNamIsChanged("Tosho", "The pet's name does't changed");
    }
}