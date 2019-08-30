package eu.ase.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProgMainIoJson {

	public static void buildAndWriteJson(String fName) throws IOException, JSONException {
		JSONObject dataset = new JSONObject();
		dataset.put("node-ipv4", "10.2.67.99");
		dataset.put("node-mac", "E4:F6:A8");
		
		dataset.put("softwares", new JSONArray());
		
		JSONObject jsonArray0 = new JSONObject();
		jsonArray0.put("OS", "RHEL 7");
		jsonArray0.put("kernelVersion", "3.20");
		
		JSONObject jsonArray1 = new JSONObject();
		jsonArray1.put("JVM", "JDK 1.8.0 u110");
		
		dataset.append("softwares", jsonArray0);
		dataset.append("softwares", jsonArray1);
		
		System.out.println("json = \n" + JSONObject.quote(dataset.toString()));
		
		FileWriter fw = new FileWriter(fName);
		fw.write(dataset.toString());
		fw.close();
	}
	
	public static void readAndParseJson(String fName) throws IOException, JSONException {
		BufferedReader reader = new BufferedReader(new FileReader(fName));
		
		String line = null;
		StringBuilder strBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		
		while ( (line = reader.readLine()) != null ) {
			strBuilder.append(line);
			strBuilder.append(ls);
		}
		
		reader.close();
		
		String myNodeJsonStr = strBuilder.toString();
		JSONObject json = new JSONObject(myNodeJsonStr);
		
		System.out.println("IP v4 = " + json.get("node-ipv4"));
		
		JSONArray swsArray = (JSONArray)json.get("softwares"); //= json.getJSONArray("softwares");
		System.out.println("JVM = " + swsArray.get(1));
	}
	
	public static void main(String[] args) {
		try {
			buildAndWriteJson("myNode.json");
			readAndParseJson("myNode.json");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(JSONException je) {
			je.printStackTrace();
		}

	}

}
