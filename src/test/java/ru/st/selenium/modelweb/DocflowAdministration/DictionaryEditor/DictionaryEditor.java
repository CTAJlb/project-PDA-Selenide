package ru.st.selenium.modelweb.DocflowAdministration.DictionaryEditor;


import ru.st.selenium.modelweb.AccessRights;

/**
 * Модель объекта - Редактор словарей
 */
public class DictionaryEditor {

    private String dictionaryEditorName;
    private AccessRights accessDiction;
    private DictionaryEditorField[] dictionaryEditorFields;

    /**
     * Название Словаря
     *
     */
    public String getDictionaryEditorName() {
        return dictionaryEditorName;
    }

    public DictionaryEditor setDictionaryEditorName(
            String dictionaryEditorName) {
        this.dictionaryEditorName = dictionaryEditorName;
        return this;
    }

    /**
     * Права доступа к Словарю
     *
     */
    public AccessRights getAccessDiction() {
        return accessDiction;
    }

    public DictionaryEditor setAccessDiction(AccessRights accessDiction) {
        this.accessDiction = accessDiction;
        return this;
    }

    /**
     * Массив полей - Редактора словарей
     *
     */
    public DictionaryEditorField[] getDictionaryEditorFields() {
        return dictionaryEditorFields;
    }

    public DictionaryEditor setDictionaryEditorFields(DictionaryEditorField[] dictionaryEditorFields) {
        this.dictionaryEditorFields = dictionaryEditorFields;
        return this;
    }


}
