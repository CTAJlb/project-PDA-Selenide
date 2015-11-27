package ru.st.selenium.model;

/*
Модель объекта системы - Пользователь
 */
public class Employee {

    private String loginName;
    private String password;
    private String lastname;
    private String name;
    private String patronymic;


    /**
     * Фамилия
     */
    public String getLastName() {
        return lastname;
    }

    public Employee setLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    /**
     * Имя
     */
    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Отчество
     */
    public String getPatronymic() {
        return patronymic;
    }

    public Employee setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    /**
     * Имя пользователя (login)
     */
    public String getLoginName() {
        return loginName;
    }

    public Employee setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    /**
     * Пароль
     */
    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }


}