package ru.st.selenium.model.TaskTypeListFields;

/**
 * Модель объекта системы - Тип поля "Целое"
 */
public class TypeListFieldsInt extends ParentTypeListFields {

    private boolean objectLink;
    private boolean formatNumber;


    /**
     * Ссылка на объект; true == Задача; false == Нет
     */
    public boolean getObjectLink() {
        return objectLink;
    }

    public TypeListFieldsInt setObjectLink(boolean objectLink) {
        this.objectLink = objectLink;
        return this;
    }

    /**
     * Формат; true == Другой формат; false == Значение по умолчанию
     */
    public boolean getFormatNumber() {
        return formatNumber;
    }

    public TypeListFieldsInt setFormatNumber(boolean formatNumber) {
        this.formatNumber = formatNumber;
        return this;
    }

}
