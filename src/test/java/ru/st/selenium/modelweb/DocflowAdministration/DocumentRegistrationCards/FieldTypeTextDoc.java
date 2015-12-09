package ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards;


import ru.st.selenium.modelweb.Directories.Directory;

/**
 * Модель объекта системы - Тип поля документа "Текст"
 */
public class FieldTypeTextDoc extends ParentFieldTypeDoc {

    private String nameDirectory;
    private Directory directory;
    private String directoryTemplate;
    private boolean selectOnlyFromDictionary;


    /**
     * Название спр-ка - в поле типа "Текст"
     *
     * @return
     */
    public String getDirectoryName() {
        return nameDirectory;
    }

    public FieldTypeTextDoc setDirectoryName(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        return this;
    }

    /**
     * Справочник
     *
     * @return FieldTypeTextDoc
     */
    public Directory getDirectoryForFieldText() {
        return directory;
    }

    public FieldTypeTextDoc setDirectoryForFieldText(Directory directory) {
        this.directory = directory;
        return this;
    }

    /**
     * Шаблон справочника
     *
     * @return FieldTypeTextDoc
     */
    public String getDirectoryTemplate() {
        return directoryTemplate;
    }

    public FieldTypeTextDoc setDirectoryTemplate(String directoryTemplate) {
        this.directoryTemplate = directoryTemplate;
        return this;
    }

    /**
     * Выбор только из справочника
     *
     * @return FieldTypeTextDoc
     */
    public boolean getSelectOnlyFromDictionary() {
        return selectOnlyFromDictionary;
    }

    public FieldTypeTextDoc setSelectOnlyFromDictionary(boolean selectOnlyFromDictionary) {
        this.selectOnlyFromDictionary = selectOnlyFromDictionary;
        return this;
    }


}
