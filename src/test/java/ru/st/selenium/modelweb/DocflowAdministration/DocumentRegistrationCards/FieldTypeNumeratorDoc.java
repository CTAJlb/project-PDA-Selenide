package ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards;

/**
 * Модель объекта системы - Тип поля документа "Нумератор"
 */
public class FieldTypeNumeratorDoc extends ParentFieldTypeDoc {

    private String numeratorTemplateDoc;
    private boolean editionAvailableWhileCreation;

    /**
     * Поле - Шаблон нумератора документа
     *
     * @return FieldTypeNumeratorDoc
     */
    public String getNumeratorTemplateDoc() {
        return numeratorTemplateDoc;
    }

    public FieldTypeNumeratorDoc setNumeratorTemplateDoc(
            String numeratorTemplateDoc) {
        this.numeratorTemplateDoc = numeratorTemplateDoc;
        return this;
    }

    /**
     * Изменяемое при создании
     *
     * @return FieldTypeNumeratorDoc
     */
    public boolean getEditionAvailableWhileCreation() {
        return editionAvailableWhileCreation;
    }

    public FieldTypeNumeratorDoc setEditionAvailableWhileCreation(boolean editionAvailableWhileCreation) {
        this.editionAvailableWhileCreation = editionAvailableWhileCreation;
        return this;
    }

}
