package json_deserialize;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import json_deserialize.model.Employee;

public class Main {

	static String json1 = "{\"id\": 1,\"name\": \"Mert Demirkıran\",\"department\": \"Software\"}";
	
	static String json2 = "{\"success\": true,"
			    +  "\"result\":{\"id\": 1,\"name\": \"Mert Demirkıran\",\"department\": \"Software\"}"
			    + "}";
	
	static String json3 = "{ \"result\":[" 
						+   "{\"id\": 1,\"name\": \"Mert Demirkıran\",\"department\": \"Software\"},"
						+   "{\"id\": 2,\"name\": \"Emrah Gökden\",\"department\": \"Marketing\"}," 
						+   "{\"id\": 3,\"name\": \"Aslı Kaya\",\"department\": \"Accounting\"}" 
				       +   "]"
			   +   "}";
	
	static String json4 = "{\"success\": true,"
			    +  "\"result\":[" 
						+   "{\"id\": 1,\"name\": \"Mert Demirkıran\",\"department\": \"Software\"},"
						+   "{\"id\": 2,\"name\": \"Emrah Gökden\",\"department\": \"Marketing\"}," 
						+   "{\"id\": 3,\"name\": \"Aslı Kaya\",\"department\": \"Accounting\"}" 
				      +   "]"
			   +  "}";
	
	public static void main(String[] args) {
		
		JSONObject json1Obj = new JSONObject(json1);
		
		System.out.println(json1Obj);
		
		Employee emp = getEmployee(json1Obj);
		
		System.out.println(emp.toString()+"\n");
		
		JSONObject json2Obj = new JSONObject(json2);
		
		System.out.println(json2Obj);
		
		emp = getEmployee(json2Obj.getJSONObject("result"));
		
		System.out.println(emp.toString()+"\n");
		
		JSONObject json3Obj = new JSONObject(json3);
		
		System.out.println(json3Obj);
		
		JSONArray jsonArr = json3Obj.getJSONArray("result");
		
		List<Employee> empList = getEmployeeList(jsonArr);
		
		for(Employee employee:empList) {
			System.out.println(employee.toString());
		}
		
		System.out.println();
		
		JSONObject json4Obj = new JSONObject(json4);
		
		System.out.println(json4Obj);
		
	   	jsonArr = json4Obj.getJSONArray("result");
		
		empList = getEmployeeList(jsonArr);
		
		for(Employee employee:empList) {
			System.out.println(employee.toString());
		}	

	}
	
	public static Employee getEmployee(JSONObject jsonObj) {
		
		Employee emp = new Employee();
		
		emp.setEmpId(jsonObj.getInt("id"));
		emp.setEmpAd(jsonObj.getString("name"));
		emp.setEmpDept(jsonObj.getString("department"));
		
		return emp;
		
	}
	
	public static List<Employee> getEmployeeList(JSONArray jsonArr){
		
		List<Employee> empList = new ArrayList<Employee>();
		
		for(int i=0;i<jsonArr.length();i++) {
			
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			
			Employee emp = new Employee();
			
			emp.setEmpId(jsonObj.getInt("id"));
			emp.setEmpAd(jsonObj.getString("name"));
			emp.setEmpDept(jsonObj.getString("department"));
			
			empList.add(emp);
			
		}
		
		return empList;
		
	}

}
