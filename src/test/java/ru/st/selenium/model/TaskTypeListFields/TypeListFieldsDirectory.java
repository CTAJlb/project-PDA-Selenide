package ru.st.selenium.model.TaskTypeListFields;

import ru.st.selenium.model.Directories.Directories;
import ru.st.selenium.model.Directories.DirectoryField;

/**
 * Модель объекта системы - Тип поля "Ссылка на cправочник"
 */
public class TypeListFieldsDirectory extends ParentTypeListFields {

    private String nameDirectory;
    private String nameDirectoryField;
    private Directories directories;
    private DirectoryField field;
    private DirectoryField linkedWithField;
    private String displayNameTemplate;


    /**
     * Название спр-ка
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
     */
    public Directories getDirectories() {
        return directories;
    }

    public TypeListFieldsDirectory setDirectories(Directories directories) {
        this.directories = directories;
        return this;
    }

    /**
     * Поле спр-ка
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
     */
    public String getDisplayNameTemplate() {
        return displayNameTemplate;
    }

    public TypeListFieldsDirectory setDisplayNameTemplate(String displayNameTemplate) {
        this.displayNameTemplate = displayNameTemplate;
        return this;
    }


}
