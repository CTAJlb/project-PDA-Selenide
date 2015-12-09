package ru.st.selenium.modelweb.FieldsObject;


import ru.st.selenium.modelweb.Directories.Directory;
import ru.st.selenium.modelweb.Directories.DirectoryField;

/**
 * Модель объекта системы - Тип поля "Ссылка на cправочник"
 */
public class TypeListFieldsDirectory extends ParentFieldsObject {

    private String nameDirectory;
    private String nameDirectoryField;
    private Directory directory;
    private DirectoryField field;
    private DirectoryField linkedWithField;
    private String displayNameTemplate;


    /**
     * Название спр-ка
     *
     * @return
     */
    public String getDirectoryName() {
        return nameDirectory;
    }

    public TypeListFieldsDirectory setDirectoryName(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        return this;
    }

    /**
     * Название поля спр-ка
     *
     * @return
     */
    public String getNameDirectoryField() {
        return nameDirectoryField;
    }

    public TypeListFieldsDirectory setNameDirectoryField(String nameDirectoryField) {
        this.nameDirectoryField = nameDirectoryField;
        return this;
    }

    /**
     * Справочник
     *
     * @return
     */
    public Directory getDirectory() {
        return directory;
    }

    public TypeListFieldsDirectory setDirectory(Directory directory) {
        this.directory = directory;
        return this;
    }

    /**
     * Поле спр-ка
     *
     * @return
     */
    public DirectoryField getFieldDirectory() {
        return field;
    }

    public TypeListFieldsDirectory setFieldDirectory(DirectoryField field) {
        this.field = field;
        return this;
    }

    /**
     * Связан с полем
     *
     * @return
     */
    public DirectoryField getLinkedWithField() {
        return linkedWithField;
    }

    public TypeListFieldsDirectory setLinkedWithField(DirectoryField linkedWithField) {
        this.linkedWithField = linkedWithField;
        return this;
    }

    /**
     * Шаблон отображения
     *
     * @return
     */
    public String getDisplayNameTemplate() {
        return displayNameTemplate;
    }

    public TypeListFieldsDirectory setDisplayNameTemplate(String displayNameTemplate) {
        this.displayNameTemplate = displayNameTemplate;
        return this;
    }



}
