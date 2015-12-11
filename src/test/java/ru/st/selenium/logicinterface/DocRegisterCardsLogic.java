package ru.st.selenium.logicinterface;

import ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards.DocRegisterCards;
import ru.st.selenium.pagesweb.DocflowAdministration.FormDocRegisterCardsEditPageWeb;

/**
 * РКД
 */
public interface DocRegisterCardsLogic {

    FormDocRegisterCardsEditPageWeb addDocRegisterCards();

    void editDocRegisterCards(DocRegisterCards directories);

    void removeAnDocRegisterCards(DocRegisterCards directories);

}
