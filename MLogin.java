import java.util.Scanner;
import java.awt.*;
import java.lang.*;
import java.io.*;

class MLogin{

	private String userName = "cts123";
	private String password = "cts123";
	private String userNameAdmin = "admin123";
	private String passwordAdmin = "admin123";


	public int loginProc(String userName, String password){
		int error = 0;
		int good = 1;
		if(userName.equalsIgnoreCase(this.userName) && password.equalsIgnoreCase(this.password)){
			return good;
		}else{
			return error;
		}

		
	}

	public int loginProcAdmin(String userNameAdmin, String passwordAdmin){
		int error = 0;
		int good = 1;
		if(userNameAdmin.equalsIgnoreCase(this.userNameAdmin) && passwordAdmin.equalsIgnoreCase(this.passwordAdmin)){
			return good;
		}else{
			return error;
		}
	}

	
}