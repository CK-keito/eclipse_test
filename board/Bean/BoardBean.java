package Bean;

public class BoardBean {

	private int id;
	private String name;
	private String mail;
	private String time_contribute;
	private String time_edit;
	private String content;
	private String app_file;





	public BoardBean(int id, String name, String mail, String time_contribute, String time_edit, String content,
			String app_file) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.time_contribute = time_contribute;
		this.time_edit = time_edit;
		this.content = content;
		this.app_file = app_file;
	}


	public BoardBean(String name, String mail, String time_contribute, String content, String app_file) {
		super();
		this.name = name;
		this.mail = mail;
		this.time_contribute = time_contribute;
		this.content = content;
		this.app_file = app_file;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTime_contribute() {
		return time_contribute;
	}


	public void setTime_contribute(String time_contribute) {
		this.time_contribute = time_contribute;
	}


	public String getTime_edit() {
		return time_edit;
	}


	public void setTime_edit(String time_edit) {
		this.time_edit = time_edit;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getApp_file() {
		return app_file;
	}


	public void setApp_file(String app_file) {
		this.app_file = app_file;
	}






}