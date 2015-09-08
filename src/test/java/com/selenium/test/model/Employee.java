package com.selenium.test.model;

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
     *  Фамилия
     * @return
     */
    public String getLastName() {
        return lastname;
    }

    public Employee setLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    /**
     *  Имя
     * @return
     */
    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    /**
     *  Отчество
     * @return
     */
    public String getPatronymic() {
        return patronymic;
    }

    public Employee setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    /**
     *  Имя пользователя (login)
     * @return
     */
    public String getLoginName() {
        return loginName;
    }

    public Employee setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    /**
     *  Пароль
     * @return
     */
    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }


}
