package jsonParseTesting.jsonParseTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, JsonProcessingException
    {
    	BufferedReader reader;
		try {
			
			String s = "";
			reader = new BufferedReader(new FileReader(
					"C:\\Users\\Jiten\\OneDrive - ICX4 Ltd\\java_practice\\Java\\jsonParseTesting\\resources\\jsonFile.txt"));
			String line = reader.readLine();
			while (line != null) {

				s = s + line;
				// read next line
				line = reader.readLine();
			}
			reader.close();
			
			System.out.println(escape(s));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//    	Scanner scanner = new Scanner(new File("C:\\Users\\Jiten\\OneDrive - ICX4 Ltd\\java_practice\\Java\\jsonParseTesting\\resources\\jsonFile.txt")); 
//    	
//    	String json = scanner.next();
//    	
//    	File f = new File("C:\\Users\\Jiten\\OneDrive - ICX4 Ltd\\java_practice\\Java\\jsonParseTesting\\resources\\jsonFile.txt");
//    	
//   	
//    	Map<String, Object> params = new HashMap<String, Object>();
//    	params.put("message", json);
//    	String payload = new ObjectMapper().writeValueAsString(params);
//    	
//    	System.out.println(payload);

    }
    
    public static Map<String, Map<String,List<String>>> formatEntityDefinition (String entityDefinition) throws Exception { 
    	String keyName = null;
    	String keyValue = null;
    	JsonToken token = null;
    	Map<String,Map<String,List<String>>> basisOfMatchMap = new HashMap<>();
    	//entityDefinition = entityDefinition.replaceAll("\\\\", "\\\\\\\\\\\\\\\\");
    	try (JsonParser jsonParser = new JsonFactory().createParser(new StringReader(entityDefinition))) {
    	jsonParser.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    	int sourceId = 0;
    	String sourceKey = null;
    	String entityKey = null;
    	while ((token = jsonParser.nextToken()) != null) {
    	if (token == JsonToken.FIELD_NAME) {
    	keyName = jsonParser.getCurrentName();
    	           } else if (token == JsonToken.VALUE_STRING || token == JsonToken.VALUE_NUMBER_INT || token == JsonToken.VALUE_NUMBER_FLOAT) {
    	            try {
    	            keyValue = jsonParser.getValueAsString();
    	            if (keyName.equalsIgnoreCase("source_id")) {
    	            sourceId = (int) Double.parseDouble(keyValue);
    	            } else if (keyName.equalsIgnoreCase("primary_key")) {
    	            sourceKey = keyValue;
    	            if (sourceKey != null) {
    	            entityKey = sourceKey+"xxx"+sourceId;
    	            }
    	            } else if (entityKey != null) {
    	            FieldComponent fc = FieldSerializer.toFieldComponentList(keyName, keyValue);
    	            if (fc != null && fc.getStorageType() == StorageType.ORIGINAL) {
    	            StringBuilder nameString = new StringBuilder();
    	            if (fc.getFieldTypeName() != null) {
    	            nameString.append(fc.getFieldTypeName().toLowerCase().replaceAll(GlobalConstants.SPACE, GlobalConstants.UNDERSCORE));
    	            nameString.append(GlobalConstants.UNDERSCORE);
    	            }
    	            nameString.append(fc.getFieldName().toLowerCase().replaceAll(GlobalConstants.SPACE, GlobalConstants.UNDERSCORE));
    	            if (basisOfMatchMap.containsKey(entityKey)) {
    	            //((Map<String, String>) basisOfMatchMap.get(objectName)).put(keyName, keyValue);
    	            Map<String,List<String>> valueMap = basisOfMatchMap.get(entityKey);
    	            if (valueMap.containsKey(nameString.toString())) {
    	            List<String> valueList = valueMap.get(nameString.toString());
    	            valueList.add(fc.getValue().toLowerCase());
    	            } else {
    	            List<String> valueList = new ArrayList<String>();
    	            valueList.add(fc.getValue().toLowerCase());
    	            valueMap.put(nameString.toString(), valueList);
    	            }
    	            } else {
    	            Map<String,List<String>> valueMap = new HashMap<String, List<String>>();
									List<String> valueList = new ArrayList<String>();
    	            valueList.add(fc.getValue().toLowerCase());
    	            valueMap.put(nameString.toString(), valueList);
    	            basisOfMatchMap.put(entityKey, valueMap);
    	            }
    	            }             
    	            }
    	            } catch (Exception e) {
    	            break;
    	            }             
    	           } else if ((token == JsonToken.START_OBJECT) && keyName != null)  {
    	            
    	           } 
    	}
    	} catch (JsonParseException e) {
    	e.printStackTrace();
    	}
    	return basisOfMatchMap;
    	}

    
    public static String escape(String s) {
    	StringBuilder sb = new StringBuilder();
//    	s = s +  "Text with special character /\"\'\b\f\t\r\n.";
    	final int len = s.length();
		for(int i=0;i<len;i++){
			char ch=s.charAt(i);
			switch(ch){
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
                //Reference: http://www.unicode.org/versions/Unicode5.1.0/
				if((ch>='\u0000' && ch<='\u001F') || (ch>='\u007F' && ch<='\u009F') || (ch>='\u2000' && ch<='\u20FF')){
					String ss=Integer.toHexString(ch);
					sb.append("\\u");
					for(int k=0;k<4-ss.length();k++){
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				}
				else{
					sb.append(ch);
				}
			}
		}//for

		return sb.toString();
		
	}
}
