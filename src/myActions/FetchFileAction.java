package myActions;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myForms.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.tomcat.util.codec.binary.Base64;

public class FetchFileAction extends Action {
	
	HttpServletRequest requestToTransfer = null;
	String encodedImgValue = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
				
		LoginForm fetchedForm = (LoginForm)form;
		requestToTransfer = request;
		
		try {
			fetchedForm = getMeTheDbDetails(fetchedForm.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fetchedForm);
		
		request = requestToTransfer;
		
		return mapping.findForward("yourFile");
	
	}

	private LoginForm getMeTheDbDetails(int id) throws Exception {

		// defining the credentials for the jdbc connection !!
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://127.0.0.1:3306/namit_schema";
		final String USER = "root";
		final String PASS = "Intel@01";
		
		String fetchedName = null;
		Blob fetchedBlob = null;
		byte[] imageBytes = null;
		
		String myNewQuery = "select * from storage where id = " + id;
		byte[] encodedImage = null;
		
		Connection connection = null;
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(myNewQuery);

		while (resultSet.next()) {
			fetchedBlob = resultSet.getBlob("file");
			fetchedName = resultSet.getString("name");
		}
		InputStream ipStream = null;
		if (null != fetchedBlob) {
			ipStream = fetchedBlob.getBinaryStream(1, fetchedBlob.length());
			System.out.println("ipStream -- " + ipStream);
		}
		
	
		// trying base64 encoding
		String encodedImgStr = null;
		imageBytes = fetchedBlob.getBytes(1, (int)fetchedBlob.length());			
		encodedImage = Base64.encodeBase64(imageBytes);	
		encodedImgStr = new String(encodedImage);
		System.out.println("Encoded image --> "+encodedImgStr);
		
		if (null != encodedImage)
			requestToTransfer.setAttribute("base64code", encodedImgStr);
		
		LoginForm tempForm = new LoginForm();
		tempForm.setName(fetchedName);

		return tempForm;
	}
	
	
}
