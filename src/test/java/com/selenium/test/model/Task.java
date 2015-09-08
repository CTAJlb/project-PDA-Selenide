package com.selenium.test.model;

/*
Модель объекта системы - Задача
 */
public class Task {


    private String taskName;
    private String description;
    private boolean important;
    private boolean withReport;
    private boolean secret;
    private boolean forReview;
    private String begin;
    private String end;
    private Employee[] authors;
    private Employee[] controllers;
    private Employee[] executiveManagers;
    private Employee[] performers;


    /**
     * Название задачи
     *
     * @return
     */
    public String getTaskName() {
        return taskName;
    }

    public Task setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    /**
     * Описание задачи
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Важная задача - true Обычная - false
     *
     * @return
     */
    public boolean getIsImportant() {
        return important;
    }

    public Task setIsImportant(boolean important) {
        this.important = important;
        return this;
    }

    /**
     * C докладом - true Без доклада - false
     *
     * @return
     */
    public boolean getIsWithReport() {
        return withReport;
    }

    public Task setIsWithReport(boolean withReport) {
        this.withReport = withReport;
        return this;
    }

    /**
     * Секретная задача - true Нет - false
     *
     * @return
     */
    public boolean getIsSecret() {
        return secret;
    }

    public Task setIsSecret(boolean secret) {
        this.secret = secret;
        return this;
    }

    /**
     * Начало
     *
     * @return
     */
    public String getBegin() {
        return begin;
    }

    public Task setBegin(String begin) {
        this.begin = begin;
        return this;
    }

    /**
     * Окончание
     *
     * @return
     */
    public String getEnd() {
        return end;
    }

    public Task setEnd(String end) {
        this.end = end;
        return this;
    }

    /**
     * Авторы - массив объектов - типа сотрудник
     *
     * @return
     */
    public Employee[] getAuthors() {
        return authors;
    }

    public Task setAuthors(Employee[] authors) {
        this.authors = authors;
        return this;
    }

    /**
     * Контролеры - массив объектов - типа сотрудник
     *
     * @return
     */
    public Employee[] getTaskSupervisors() {
        return controllers;
    }

    public Task setTaskSupervisors(Employee[] controllers) {
        this.controllers = controllers;
        return this;
    }

    /**
     * Ответственные руководители - массив объектов - типа сотрудник
     *
     * @return
     */
    public Employee[] getExecutiveManagers() {
        return executiveManagers;
    }

    public Task setExecutiveManagers(Employee[] executiveManagers) {
        this.executiveManagers = executiveManagers;
        return this;
    }

    /**
     * Исполнители - массив объектов - типа сотрудник
     *
     * @return
     */
    public Employee[] getPerformers() {
        return performers;
    }

    public Task setPerformers(Employee[] performers) {
        this.performers = performers;
        return this;
    }


}
