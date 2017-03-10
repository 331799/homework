package com.homework.test.ui;

import com.homework.main.model.CreateAdModel;
import com.homework.main.model.RubricModel;
import com.homework.main.model.RubricModels.RubricAnimalModel;
import org.testng.annotations.Test;

public class UiTest extends UiBasicTestCase {

    CreateAdModel model = new CreateAdModel("Some title", "Some description with a 20 symbol", "Киевка", "MyName");
    RubricModel rubric = new RubricModel("Животные", "Кошки", null);
    RubricAnimalModel rubricAnimalModel = new RubricAnimalModel()
            .withPrice("100").withCurrency("€").withContractPrice(true)
            .withBusiness("Бизнес").withBreed("Бенгальская").withDescription("Some long long description");

    @Test
    public void addCreationTest() {
        // click createAd button
        app.getNavigatorHelper().goToCreateAdd();
        // login into system
        app.getSessionHelper().login(testUser);
        // choose rubric
        app.getRubricHelper().chooseRubric(rubric);
        // fill ad creation form
        app.getCreateAdHelper().fillAdCreationForm(model, true);
        // fill animals rubric form
        app.getRubricHelper().getAnimalsRubricHelper().fillRubric(rubricAnimalModel);
        // click post ad
//        app.getCreateAdHelper().postAd();
    }
}
