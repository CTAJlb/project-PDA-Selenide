package ru.st.selenium.modelweb.DocflowAdministration.DictionaryEditor;

/**
 * Модель объекта системы - Поля объекта "Словарь"
 */
public class DictionaryEditorField {

    private String nameDictionItem;
    private String descriptionDictionItem;


    /**
     * Название Элемента словаря
     */
    public String getNameDictionItem() {
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
    public String getDescriptionDictionItem() {
        return descriptionDictionItem;
    }

    public DictionaryEditorField setDescriptionDictionItem(
            String descriptionDictionItem) {
        this.descriptionDictionItem = descriptionDictionItem;
        return this;
    }


}

