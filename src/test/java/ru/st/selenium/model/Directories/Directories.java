package ru.st.selenium.model.Directories;

/**
 *  Модель объекта системы - Справочники (Администрирование/Справочники)
 */
public class Directories {

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

    public Directories setDirectoryName(String nameDirectoryName) {
        this.directoryName = nameDirectoryName;
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
    public boolean getSetAccessToRecords() {
        return setAccessToRecords;
    }

    public Directories setSetAccessToRecords(boolean setAccessToRecords) {
        this.setAccessToRecords = setAccessToRecords;
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
     *  Поля - массив объектов - типа поле справочника
     */
    public DirectoryField[] getDirectoryFields() {
        return directoryFields;
    }

    public Directories setDirectoryFields(DirectoryField[] directoryFields) {
        this.directoryFields = directoryFields;
        return this;
    }

}