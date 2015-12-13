package ru.st.selenium.model.Directories;

import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.FieldsObject.ParentFieldsObject;

/**
 * Модель объекта системы - Поля объекта "Справочник"
 */
public class DirectoryField {

    private String fieldName;
    private String fieldID;
    private boolean dictionaryObligatory;
    private boolean isUniqueField;
    private ParentFieldsObject field;
    private OpenFilesForEdit openFilesForEdit;


    /**
     * Название поля
     *
     */
    public String getFieldName() {
        return fieldName;
    }

    public DirectoryField setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    /**
     * Идентификатор поля
     *
     */
    public String getFieldID() {
        return fieldID;
    }

    public DirectoryField setFieldID(String fieldID) {
        this.fieldID = fieldID;
        return this;
    }

    /**
     * Тип поля
     *
     */
    public ParentFieldsObject getTaskTypeField() {
        return field;
    }

    public DirectoryField setFieldType(ParentFieldsObject field) {
        this.field = field;
        return this;
    }

    /**
     * Обязательность поля
     */
    public boolean getObligatory() {
        return dictionaryObligatory;
    }

    public DirectoryField setObligatory(boolean dictionaryObligatory) {
        this.dictionaryObligatory = dictionaryObligatory;
        return this;
    }

    /**
     * Уникальное поле
     *
     */
    public boolean getIsUniqueField() {
        return isUniqueField;
    }

    public DirectoryField setIsUniqueField(boolean isUniqueField) {

        this.isUniqueField = isUniqueField;
        return this;
    }

    /**
     * Разрешить редактирование файлов для поля типа "Файл"
     *
     */
    public OpenFilesForEdit getOpenFilesForEdit() {
        return openFilesForEdit;
    }

    public DirectoryField setOpenFilesForEdit(OpenFilesForEdit openFilesForEdit) {
        this.openFilesForEdit = openFilesForEdit;
        return this;
    }


}
