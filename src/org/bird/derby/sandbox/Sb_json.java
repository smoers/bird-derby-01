package org.bird.derby.sandbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.bird.derby.utils.Encrypt;

public class Sb_json {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		
		try {
	    	 InputStream input = new FileInputStream(new File("dbconfig.json"));
	         JsonReader reader = Json.createReader(input);

	         JsonObject jobj = reader.readObject();
	         JsonObject jobj2 = jobj.getJsonObject("jdbc");
	         
	         System.out.println(jobj2.getJsonString("password"));
	         System.out.println(Encrypt.decrypt(jobj2.getJsonString("password").getString()));
	         List lst = jobj.getJsonArray("database");
	         System.out.println(lst);
	        

	      } catch (Exception ex) {
	         System.out.println(ex);
	      }
		
		
	
	}
	
	

}
