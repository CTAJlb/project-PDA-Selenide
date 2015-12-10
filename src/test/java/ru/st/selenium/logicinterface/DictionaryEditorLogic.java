package ru.st.selenium.logicinterface;

import ru.st.selenium.modelweb.DocflowAdministration.DictionaryEditor.DictionaryEditor;

/**
 * Редактор словарей
 */
public interface DictionaryEditorLogic {

    void addDictionaryEditor(DictionaryEditor directoriesEditor);

    void editDictionaryEditor(DictionaryEditor directoriesEditor);

    void removeAnDictionaryEditor(DictionaryEditor directoriesEditor);
}
