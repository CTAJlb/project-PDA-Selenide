package ru.st.selenium.model.Administration.Directories;

/**
 * Модель объекта системы - Справочники (Администрирование/Справочники)
 */
public class Directories {

    private String nameDirectoryName;
    private boolean shareRecords;
    private boolean accessToRecords;
    private boolean isMappingDevice;
    private boolean searchSettings;
    private DirectoryField[] directoryFields;

    /**
     * Конструктор класса - Справочники
     * @param nameDirectoryName
     */
    public Directories(String nameDirectoryName) {
        this.nameDirectoryName = nameDirectoryName;
    }



    /**
     * Название - Справочники
     */
    public String getDirectoryName() {
        return nameDirectoryName;
    }

    public Directories setDirectoryName(String nameDirectoryName) {
        this.nameDirectoryName = nameDirectoryName;
        return this;
    }

    /**
     * Общедоступность записей
     */
    public boolean getShareRecords() {
        return shareRecords;
    }

    public Directories setShareRecords(boolean shareRecords) {
        this.shareRecords = shareRecords;
        return this;
    }

    /**
     * Настройка доступа к записям
     */
    public boolean getAccessToRecords() {
        return accessToRecords;
    }

    public Directories setAccessToRecords(boolean accessToRecords) {
        this.accessToRecords = accessToRecords;
        return this;
    }

    /**
     * Линейный ли? true - да false - иерархический
     */
    public boolean getMappingDevice() {
        return isMappingDevice;
    }

    public Directories setMappingDevice(boolean isMappingDevice) {
        this.isMappingDevice = isMappingDevice;
        return this;
    }

    /**
     * true - поиск записей через SOLR; false - поиск записей через БД
     */
    public boolean getSearchSettings() {
        return searchSettings;
    }

    public Directories setSearchSettings(boolean searchSettings) {
        this.searchSettings = searchSettings;
        return this;
    }

    /**
     * Поля - массив объектов - типа поле справочника
     */
    public DirectoryField[] getDirectoryFields() {
        return directoryFields;
    }

    public Directories setDirectoryFields(DirectoryField[] directoryFields) {
        this.directoryFields = directoryFields;
        return this;
    }

}