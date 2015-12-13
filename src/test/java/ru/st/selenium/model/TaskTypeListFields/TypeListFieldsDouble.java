package ru.st.selenium.model.TaskTypeListFields;

/**
 *  Модель объекта системы - Тип поля "Вещественное"
 */
public class TypeListFieldsDouble extends ParentTypeListFields {

    private boolean formatNumber;


    /**
     * Формат; true == Другой формат; false == Значение по умолчанию
     *
     */
    public boolean getFormatNumber() {
        return formatNumber;
    }

    public TypeListFieldsDouble setFormatNumber(boolean formatNumber) {
        this.formatNumber = formatNumber;
        return this;
    }



}
