package ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards;


import ru.st.selenium.modelweb.DocflowAdministration.DictionaryEditor.DictionaryEditor;

/**
 * Модель объекта системы - Тип поля документа "Словарь"
 */
public class FieldTypeDictionaryDoc extends ParentFieldTypeDoc {

    private String nameDictionaryEditor;
    private DictionaryEditor dictionaryEditor;


    /**
     * Название объекта - Словарь
     *
     * @return
     */
    public String getNameDictionaryEditor() {
        return nameDictionaryEditor;
    }

    public FieldTypeDictionaryDoc setNameDictionaryEditor(String nameDictionaryEditor) {
        this.nameDictionaryEditor = nameDictionaryEditor;
        return this;
    }

    /**
     * Словарь
     *
     * @return
     */
    public DictionaryEditor getDictionaryEditor() {
        return dictionaryEditor;
    }

    public FieldTypeDictionaryDoc setDictionaryEditor(DictionaryEditor dictionaryEditor) {
        this.dictionaryEditor = dictionaryEditor;
        return this;
    }

}
