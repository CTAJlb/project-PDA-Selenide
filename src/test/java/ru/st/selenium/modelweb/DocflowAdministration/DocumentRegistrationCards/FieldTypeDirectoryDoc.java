package ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards;


import ru.st.selenium.modelweb.Directories.Directory;

/**
 * Модель объекта системы - Тип поля документа "Справочник"
 */
public class FieldTypeDirectoryDoc extends ParentFieldTypeDoc {

    private String nameDirectory;
    private Directory directory;
    private String directoryTemplate;
    private boolean directoryEntriesSelection;


    /**
     * Название спр-ка
     *
     * @return
     */
    public String getNameDirectoryDoc() {
        return nameDirectory;
    }

    public FieldTypeDirectoryDoc setNameDirectoryDoc(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        return this;
    }

    /**
     * Справочник
     *
     * @return
     */
    public Directory getDirectoryDoc() {
        return directory;
    }

    public FieldTypeDirectoryDoc setDirectoryDoc(Directory directory) {
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

    public FieldTypeDirectoryDoc setDirectoryTemplate(String directoryTemplate) {
        this.directoryTemplate = directoryTemplate;
        return this;
    }

    /**
     * Выбор записей спр-ка; true == Одна запись; false == Несколько записей
     *
     * @return
     */
    public boolean getDirectoryEntriesSelection() {
        return directoryEntriesSelection;
    }

    public FieldTypeDirectoryDoc setDirectoryEntriesSelection(boolean directoryEntriesSelection) {
        this.directoryEntriesSelection = directoryEntriesSelection;
        return this;
    }


}
