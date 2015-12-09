package ru.st.selenium.modelweb.FieldsObject;


import ru.st.selenium.modelweb.Directories.Directory;

/**
 * Модель объекта системы - Тип поля "Вложенный справочник"
 */
public class TypeListFieldsEnclosedDirectory extends ParentFieldsObject {

    private Directory directory;
    private String nameDirectory;

    /**
     * Название спр-ка
     *
     * @return
     */
    public String getDirectoryName() {
        return nameDirectory;
    }

    public TypeListFieldsEnclosedDirectory setDirectoryName(String nameDirectory) {
        this.nameDirectory = nameDirectory;
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

    public TypeListFieldsEnclosedDirectory setDirectory(Directory directory) {
        this.directory = directory;
        return this;
    }


}
