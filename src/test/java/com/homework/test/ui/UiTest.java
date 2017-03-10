package com.homework.test.ui;

import com.homework.main.model.CreateAdModel;
import com.homework.main.model.RubricModel;
import com.homework.main.model.RubricModels.RubricAnimalModel;
import org.testng.annotations.Test;

public class UiTest extends UiBasicTestCase {

    CreateAdModel model = new CreateAdModel("Some title", "Some description with a 20 symbol", "MyLocation", "MyName");
    RubricModel rubric = new RubricModel("Транспорт", "Мото", "Мотоциклы");
    RubricAnimalModel rubricAnimalModel = new RubricAnimalModel()
            .withPrice("100").withBusiness("Бизнес").withBreed("Бенгальская").withDescription("Description");

    @Test
    public void addCreationTest() throws InterruptedException {
        app.getNavigatorHelper().goToCreateAdd();
        app.getSessionHelper().login(testUser);
        app.getRubricHelper().chooseRubric(rubric);
        app.getCreateAdHelper().fillAdCreationForm(model, true);
        app.getRubricHelper().getAnimalsRubricHelper().fillRubric(rubricAnimalModel);
        Thread.sleep(10000);

//        app.getCreateAdHelper().postAdd();
    }
}
