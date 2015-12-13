package ru.st.selenium.model.TypesOfTables;

/**
 * Модель объекта системы - Типы таблиц (Администрирование/Типы таблиц)
 */
public class TypesOfTables {

    private String nameTableType;
    private boolean mappingDevice;
    private TypesOfTablesField[] typesOfTablesFields;


    /**
     * Название - Типы таблиц
     */
    public String getTableTypeName() {
        return nameTableType;
    }

    public TypesOfTables setTableTypeName(String nameTableName) {
        this.nameTableType = nameTableName;
        return this;
    }

    /**
     * Линейный ли? true - да false - иерархический
     */
    public boolean getMappingDevice() {
        return mappingDevice;
    }

    public TypesOfTables setMappingDevice(boolean mappingDevice) {
        this.mappingDevice = mappingDevice;
        return this;
    }

    /**
     * Поля - массив объектов - поля объекта "Типы таблиц"
     */
    public TypesOfTablesField[] getTypesOfTablesFields() {
        return typesOfTablesFields;
    }

    public TypesOfTables setTypesOfTablesFields(TypesOfTablesField[] typesOfTablesFields) {
        this.typesOfTablesFields = typesOfTablesFields;
        return this;
    }

}
