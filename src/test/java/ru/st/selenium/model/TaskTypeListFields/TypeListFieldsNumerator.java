package ru.st.selenium.model.TaskTypeListFields;

import ru.st.selenium.model.TasksTypes.ComputeModeNumerator;

/**
 * Модель объекта системы - Тип поля "Нумератор"
 */

public class TypeListFieldsNumerator extends ParentTypeListFields {

    private String numeratorTemplate;
    private ComputeModeNumerator computeMode;


    /**
     * Шаблон нумератора
     *
     */
    public String getNumeratorTemplate() {
        return numeratorTemplate;
    }

    public TypeListFieldsNumerator setNumeratorTemplate(
            String numeratorTemplate) {
        this.numeratorTemplate = numeratorTemplate;
        return this;
    }

    /**
     * Режим вычисления
     *
     */
    public ComputeModeNumerator getComputeMode() {
        return computeMode;
    }

    public TypeListFieldsNumerator setComputeMode(
            ComputeModeNumerator computeMode) {
        this.computeMode = computeMode;
        return this;
    }


}
