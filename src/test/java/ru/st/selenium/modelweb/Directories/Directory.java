package ru.st.selenium.modelweb.Directories;

/**
 *  Модель объекта системы - Справочники (Администрирование/Справочники)
 */
public class Directory {

    private String directoryName;
    private boolean shareRecords;
    private boolean setAccessToRecords;
    private boolean isMappingDevice;
    private boolean searchSettings;
    private DirectoryField[] directoryFields;


    /**
     *  Название - Справочники
     */
    public String getDirectoryName() {
        return directoryName;
    }

    public Directory setDirectoryName(String nameDirectoryName) {
        this.directoryName = nameDirectoryName;
        return this;
    }

    /**
     * Общедоступность записей
     */
    public boolean getShareRecords() {
        return shareRecords;
    }

    public Directory setShareRecords(boolean shareRecords) {
        this.shareRecords = shareRecords;
        return this;
    }

    /**
     * Настройка доступа к записям
     */
    public boolean getSetAccessToRecords() {
        return setAccessToRecords;
    }

    public Directory setSetAccessToRecords(boolean setAccessToRecords) {
        this.setAccessToRecords = setAccessToRecords;
        return this;
    }

    /**
     * Линейный ли? true - да false - иерархический
     */
    public boolean getMappingDevice() {
        return isMappingDevice;
    }

    public Directory setMappingDevice(boolean isMappingDevice) {
        this.isMappingDevice = isMappingDevice;
        return this;
    }

    /**
     * true - поиск записей через SOLR; false - поиск записей через БД
     */
    public boolean getSearchSettings() {
        return searchSettings;
    }

    public Directory setSearchSettings(boolean searchSettings) {
        this.searchSettings = searchSettings;
        return this;
    }

    /**
     *  Поля - массив объектов - типа поле справочника
     */
    public DirectoryField[] getDirectoryFields() {
        return directoryFields;
    }

    public Directory setDirectoryFields(DirectoryField[] directoryFields) {
        this.directoryFields = directoryFields;
        return this;
    }

}