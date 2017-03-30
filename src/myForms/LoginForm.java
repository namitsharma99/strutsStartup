package myForms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private FormFile myFile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FormFile getMyFile() {
		return myFile;
	}

	public void setMyFile(FormFile myFile) {
		this.myFile = myFile;
	}

}
