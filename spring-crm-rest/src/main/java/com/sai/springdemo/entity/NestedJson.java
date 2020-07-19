package com.sai.springdemo.entity;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionRegistry;
import org.hibernate.mapping.Selectable;
import org.hibernate.mapping.Table;
import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class NestedJson implements Selectable{

	private JsonArray jsonFromJavaArrayList;
	
	
	public JsonArray getJsonFromJavaArrayList() {
		return jsonFromJavaArrayList;
	}

	public void setJsonFromJavaArrayList(JsonArray jsonFromJavaArrayList) {
		this.jsonFromJavaArrayList = jsonFromJavaArrayList;
	}

		public JsonArray createNestedJasonObject()throws SQLException, JsonProcessingException, JSONException {
			 
			 Gson gsonBuilder = new GsonBuilder().create();
				Contact contact = new Contact();
				Map<Contact, Address> fullList = new HashMap<>();
				ArrayList<Contact> contactList = new ArrayList<Contact>();
				ArrayList<Address> addressList = new ArrayList<Address>();
				ArrayList<Phone> phoneList = new ArrayList<Phone>();
				ArrayList<Email> emailList = new ArrayList<Email>();

				String url = "jdbc:oracle:thin:@//localhost:1521/XE";
				java.sql.Connection con = DriverManager.getConnection(url, "hr", "hr");
				String query1 = "Select * from contact ";
				String query2 = "Select * from Address ";
				String query3 = "Select * from Phone ";
				String query4 = "Select * from Email ";
				java.sql.PreparedStatement stmt = con.prepareStatement(query1);
				ResultSet rs = stmt.executeQuery(query1);
				if (rs != null) {
					while (rs.next()) {
						contact = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
						contactList.add(contact);

					}
				}
				stmt = con.prepareStatement(query2);
				rs = stmt.executeQuery(query2);

				if (rs != null) {
					while (rs.next()) {

						Address address = new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getInt(6));
						addressList.add(address);
					}
				}
				stmt = con.prepareStatement(query3);
				rs = stmt.executeQuery(query3);

				if (rs != null) {
					while (rs.next()) {

						Phone phone = new Phone(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
						phoneList.add(phone);
					}
				}

				stmt = con.prepareStatement(query4);
				rs = stmt.executeQuery(query4);

				if (rs != null) {
					while (rs.next()) {

						Email email = new Email(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
						emailList.add(email);
					}
				}

				//JSONArray contactArray = new JSONArray();
				JsonArray contactArray = new JsonArray();
				for (Contact c : contactList) {

					JsonObject jcontact = new JsonObject();
					jcontact.addProperty("Contact contactId", c.getContactId());
					jcontact.addProperty("firstName", c.getFirstName());
					jcontact.addProperty("middleName", c.getMiddleName());
					jcontact.addProperty("lastName", c.getLastName());

					// System.out.println(jcontact.toString());

					for (Address a : addressList) {
						JsonArray jaddressArray = new JsonArray();
						if (a.getContactId() == c.getContactId()) {
							JsonObject jaddress = new JsonObject();
							jaddress.addProperty("Address contactId", a.getAddressId());
							jaddress.addProperty("street", a.getStreet());
							jaddress.addProperty("city", a.getCity());
							jaddress.addProperty("state", a.getState());

							jaddressArray.add(jaddress);
							jcontact.add("address", jaddressArray);
						}
						for (Phone p : phoneList) {
							JsonArray phoneArray = new JsonArray();
							if (p.getContactId() == c.getContactId()) {
								JsonObject jphone = new JsonObject();
								jphone.addProperty("phone contactId", p.getPhoneId());
								jphone.addProperty("phoneType", p.getPhonetype());
								jphone.addProperty("phone", p.getPhone());
								phoneArray.add(jphone);
								jcontact.add("phone", phoneArray);

							}
							for (Email e : emailList) {
								JsonArray emailArray = new JsonArray();
								if (e.getContactId() == c.getContactId()) {
									JsonObject email = new JsonObject();
									email.addProperty("email contactId", e.getEmailId());
									email.addProperty("emailType", e.getEmailType());
									email.addProperty("email", e.getEmail());

									emailArray.add(email);
									jcontact.add("phone", emailArray);
									;

								}

							}

						}

					}

					contactArray.add(jcontact);
					
				}
				return contactArray;
		 }

		public static void main(String[] args)  {
			
	}

		@Override
		public String getAlias(Dialect dialect) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getAlias(Dialect dialect, Table table) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isFormula() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getTemplate(Dialect dialect, SQLFunctionRegistry functionRegistry) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getText(Dialect dialect) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getText() {
			// TODO Auto-generated method stub
			return null;
		}
	}


