package ru.st.selenium.model.TaskTypeListFields;

/**
 * Модель объекта системы - Тип поля "Строка"
 */
public class TypeListFieldsString extends ParentTypeListFields {

    private boolean listChoice;
    private String valuesList;


    /**
     * Нужен ли выбор из списка
     */
    public boolean getIsListChoice() {
        return listChoice;
    }

    public TypeListFieldsString setIsListChoice(boolean listChoice) {
        this.listChoice = listChoice;
        return this;
    }

    /**
     * Поле ввода значений для выбора из списка (Список значений)
     */
    public String getValuesList() {
        return valuesList;
    }

    public TypeListFieldsString setValuesList(String valuesList) {
        this.valuesList = valuesList;
        return this;
    }

}

