package ru.st.selenium.modelweb.TypesOfTables;


import ru.st.selenium.modelweb.FieldsObject.ParentFieldsObject;
import ru.st.selenium.modelweb.OpenFilesForEdit;

/**
 *  Модель объекта системы - поля "Типы таблиц"
 *
 */
public class TypesOfTablesField {
	private String fieldName;
	private String fieldID;
	private boolean typeTablesObligatoryField;
	private ParentFieldsObject field;
	private OpenFilesForEdit openFilesForEdit;


	/**
	 * Название поля
	 *
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}

	public TypesOfTablesField setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	/**
	 * Идентификатор поля
	 *
	 * @return
	 */
	public String getFieldID() {
		return fieldID;
	}

	public TypesOfTablesField setFieldID(String fieldID) {
		this.fieldID = fieldID;
		return this;
	}

	/**
	 * Тип поля
	 *
	 */
	public ParentFieldsObject getTaskTypeField() {
		return field;
	}

	public TypesOfTablesField setTaskTypeField(ParentFieldsObject field) {
		this.field = field;
		return this;
	}

	/**
	 * Обязательность поля
	 *
	 */
	public boolean getObligatory() {
		return typeTablesObligatoryField;
	}

	public TypesOfTablesField setObligatory(boolean typeTablesObligatoryField) {
		this.typeTablesObligatoryField = typeTablesObligatoryField;
		return this;
	}


	/**
	 * Разрешить редактирование файлов для поля типа "Файл"
	 *
	 */
	public OpenFilesForEdit getOpenFilesForEdit() {
		return openFilesForEdit;
	}

	public TypesOfTablesField setOpenFilesForEdit(OpenFilesForEdit openFilesForEdit) {
		this.openFilesForEdit = openFilesForEdit;
		return this;
	}



}