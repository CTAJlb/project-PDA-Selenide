package ru.st.selenium.logicinterface;


import ru.st.selenium.model.Administration.Directories.Directories;

/**
 * Форма редактирования Справочника
 */
public interface DirectoriesEditFormLogic {


    void addFieldDirectories(Directories directories);

    void editFieldDirectories(Directories directories);

    void removeAnFieldDirectories(Directories directories);


}
