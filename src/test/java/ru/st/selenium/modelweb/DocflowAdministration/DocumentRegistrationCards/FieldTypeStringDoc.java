package ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards;


import ru.st.selenium.modelweb.Directories.Directory;

/**
 * Модель объекта системы - Тип поля документа "Строка"
 */
public class FieldTypeStringDoc extends ParentFieldTypeDoc {

    private String nameDirectory;
    private Directory directory;
    private String directoryTemplate;
    private boolean selectOnlyFromDictionary;
    private String fieldLength;


    /**
     * Название спр-ка - в поле типа "Строка"
     *
     * @return
     */
    public String getDirectoryName() {
        return nameDirectory;
    }

    public FieldTypeStringDoc setDirectoryName(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        return this;
    }

    /**
     * Справочник
     *
     * @return FieldTypeStringDoc
     */
    public Directory getDirectoryForFieldString() {
        return directory;
    }

    public FieldTypeStringDoc setDirectoryForFieldString(Directory directory) {
        this.directory = directory;
        return this;
    }

    /**
     * Шаблон справочника
     *
     * @return FieldTypeStringDoc
     */
    public String getDirectoryTemplate() {
        return directoryTemplate;
    }

    public FieldTypeStringDoc setDirectoryTemplate(String directoryTemplate) {
        this.directoryTemplate = directoryTemplate;
        return this;
    }

    /**
     * Выбор только из справочника; true == Нет; false == Да
     *
     * @return FieldTypeStringDoc
     */
    public boolean getSelectOnlyFromDictionary() {
        return selectOnlyFromDictionary;
    }

    public FieldTypeStringDoc setSelectOnlyFromDictionary(boolean selectOnlyFromDictionary) {
        this.selectOnlyFromDictionary = selectOnlyFromDictionary;
        return this;
    }

    /**
     * Длина поля
     *
     * @return FieldTypeStringDoc
     */
    public String getFieldLength() {
        return fieldLength;
    }

    public FieldTypeStringDoc setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength;
        return this;
    }


}