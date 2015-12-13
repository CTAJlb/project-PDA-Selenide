package ru.st.selenium.model.DocflowAdministration.DictionaryEditor;

/**
 * Модель объекта системы - Поля объекта "Словарь"
 */
public class DictionaryEditorField {

    private String nameDictionItem;
    private String descriptionDictionItem;


    /**
     * Название Элемента словаря
     */
    public String getDictionaryElement() {
        return nameDictionItem;
    }

    public DictionaryEditorField setNameDictionItem(
            String nameDictionItem) {
        this.nameDictionItem = nameDictionItem;
        return this;
    }

    /**
     * Описание Элемента словаря
     */
    public String getDescriptionElement() {
        return descriptionDictionItem;
    }

    public DictionaryEditorField setDescriptionDictionItem(
            String descriptionDictionItem) {
        this.descriptionDictionItem = descriptionDictionItem;
        return this;
    }


}

