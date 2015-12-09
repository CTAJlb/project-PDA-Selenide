package ru.st.selenium.modelweb.Task;

/**
 *  Модель объекта системы - "Проект"
 *
 */

public class Project {
	
	private String nameProject;
	private String description;
	private String client;
	private String endDate;
	

	/**
	 *  Проект
	 * @return
	 */
	public String getNameProject() {
		return nameProject;
	}

	public Project setNameProject(String nameProject) {
		this.nameProject = nameProject;
		return this;
	}

	/**
	 *  Описание
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public Project setDescription(String description) {
		this.description = description;
		return this;
	}
	
	/**
	 *  Заказчик
	 * @return
	 */
	public String getСlient() {
		return client;
	}

	public Project setСlient(String client) {
		this.client = client;
		return this;
	}
	
	/**
	 *  Дата окончания проекта
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}

	public Project setEndDate(String endDate) {
		this.endDate = endDate;
		return this;
	}
	
}
