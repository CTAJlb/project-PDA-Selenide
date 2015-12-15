package ru.st.selenium.model.Directories;

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
     * @param shareRecords
     * @param accessToRecords
     * @param isMappingDevice
     * @param searchSettings
     * @param directoryFields
     */
    public Directories(String nameDirectoryName, boolean shareRecords, boolean accessToRecords,
                       boolean isMappingDevice, boolean searchSettings, DirectoryField[] directoryFields) {
        this.nameDirectoryName = nameDirectoryName;
        this.shareRecords = shareRecords;
        this.accessToRecords = accessToRecords;
        this.isMappingDevice = isMappingDevice;
        this.searchSettings = searchSettings;
        this.directoryFields = directoryFields;
    }



    /**
     * Название - Справочники
     */
    public String getNameDirectoryName() {
        return nameDirectoryName;
    }

    public Directories setNameDirectoryName(String nameDirectoryName) {
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