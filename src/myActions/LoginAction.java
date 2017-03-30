package myActions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myForms.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class LoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		LoginForm loginForm = (LoginForm) form;
		System.out.println("ID -- " + loginForm.getId() + " : " + "Name -- "
				+ loginForm.getName());
		FormFile formFile = null;
		formFile = loginForm.getMyFile();
		System.out.println("Uploaded file's details : "
				+ formFile.getFileName() + "; with size : "
				+ formFile.getFileSize());
		try {
			saveFileIntoDb(loginForm);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (formFile != null && formFile.getFileSize() != 0)
			request.setAttribute("flag", true);
		return mapping.findForward("dashboard");

	}

	private void saveFileIntoDb(LoginForm loginForm)
			throws FileNotFoundException, IOException {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://127.0.0.1:3306/namit_schema";
		final String USER = "root";
		final String PASS = "Intel@01";

		InputStream myStream = loginForm.getMyFile() != null
				&& loginForm.getMyFile().getFileSize() == 0 ? null : loginForm
				.getMyFile().getInputStream();
		int id = loginForm.getId();
		String name = loginForm.getName();

		// preparing statement for execution of object persistence in DB
		Connection connection = null;
		if (null != myStream) {
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL, USER, PASS);
				String myQuery = "insert into storage values (?, ?, ?)";
				PreparedStatement preparedstatement = connection
						.prepareStatement(myQuery);
				preparedstatement.setInt(1, id);
				preparedstatement.setString(2, name);
				preparedstatement.setBlob(3, myStream);

				preparedstatement.execute();
				System.out.println("Statements executed");
				preparedstatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
