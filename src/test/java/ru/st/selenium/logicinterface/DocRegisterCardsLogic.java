package ru.st.selenium.logicinterface;

import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.DocRegisterCards;
import ru.st.selenium.pages.pagesweb.DocflowAdministration.FormDocRegisterCardsEditPage;

/**
 * РКД
 */
public interface DocRegisterCardsLogic {

    FormDocRegisterCardsEditPage addDocRegisterCards();

    void editDocRegisterCards(DocRegisterCards directories);

    void removeAnDocRegisterCards(DocRegisterCards directories);

}
