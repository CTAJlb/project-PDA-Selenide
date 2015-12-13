package ru.st.selenium.model.TaskTypeListFields;

import ru.st.selenium.model.Directories.Directories;

/**
 *  Модель объекта системы - Тип поля "Вложенный справочник"
 */
public class TypeListFieldsEnclosedDirectory extends ParentTypeListFields {

    private Directories directory;
    private String nameDirectory;

    /**
     *  Название спр-ка
     */
    public String getDirectoryName() {
        return nameDirectory;
    }

    public TypeListFieldsEnclosedDirectory setDirectoryName(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        return this;
    }

    /**
     *  Справочник
     */
    public Directories getDirectory() {
        return directory;
    }

    public TypeListFieldsEnclosedDirectory setDirectory(Directories directory) {
        this.directory = directory;
        return this;
    }


}
