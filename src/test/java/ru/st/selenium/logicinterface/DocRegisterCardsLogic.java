package ru.st.selenium.logicinterface;

import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.DocRegisterCards;
import ru.st.selenium.pagesweb.DocflowAdministration.FormDocRegisterCardsEditPageWeb;

/**
 * РКД
 */
public interface DocRegisterCardsLogic {

    FormDocRegisterCardsEditPageWeb addDocRegisterCards();

    void editDocRegisterCards(DocRegisterCards directories);

    void removeAnDocRegisterCards(DocRegisterCards directories);

}
