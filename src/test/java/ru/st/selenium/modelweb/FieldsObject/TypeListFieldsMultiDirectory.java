package ru.st.selenium.modelweb.FieldsObject;


import ru.st.selenium.modelweb.Directories.Directories;
import ru.st.selenium.modelweb.Directories.DirectoryField;

/**
 * Модель объекта системы - Тип поля "Множественная ссылка на справочник"
 */
public class TypeListFieldsMultiDirectory extends ParentFieldsObject {

    private String nameDirectory;
    private String nameDirectoryField;
    private Directories directories;
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

    public TypeListFieldsMultiDirectory setDirectoryName(String nameDirectory) {
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

    public TypeListFieldsMultiDirectory setNameDirectoryField(String nameDirectoryField) {
        this.nameDirectoryField = nameDirectoryField;
        return this;
    }

    /**
     * Справочник
     *
     * @return
     */
    public Directories getDirectories() {
        return directories;
    }

    public TypeListFieldsMultiDirectory setDirectories(Directories directories) {
        this.directories = directories;
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

    public TypeListFieldsMultiDirectory setFieldDirectory(DirectoryField field) {
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

    public TypeListFieldsMultiDirectory setLinkedWithField(DirectoryField linkedWithField) {
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

    public TypeListFieldsMultiDirectory setDisplayNameTemplate(String displayNameTemplate) {
        this.displayNameTemplate = displayNameTemplate;
        return this;
    }


}
