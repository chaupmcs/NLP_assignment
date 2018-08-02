// class student:
// make a type Student and some helper functions
import java.util.ArrayList;
public class Student 
{
	public String name;
	public String id;
	public String subject;
	public String room;
	public String date;
	public String beginClass;
	public String numberClass;
	
	public Student(String name, String id, String subject, String room, String date, String beginClass, String numberClass) 
	{
		this.name =name;
		this.id = id;
		this.subject = subject;
		this.room = room;
		this.date = date;
		this.beginClass = beginClass;
		this.numberClass = numberClass;
	}
	
	
	public String getField(String field)
	{
		if (field.contains("sinh viên"))
			return this.name;
		if (field.contains("mã số"))
			return this.id;
		if (field.contains("môn"))
			return this.subject;
		if (field.contains("phòng"))
			return this.room;
		if (field.contains("ngày"))
			return this.date;
		
		if (field.contains("tiết bắt đầu"))
			return this.beginClass;
		else 
			if (field.contains("tiết"))
				return this.numberClass;
		
		return "__NOT_VALID__";//default
	}
	
	// helper function: upperCase the first char of each word: 
	public static String capitalize(String text){
	    String c = (text != null)? text.trim() : "";
	    String[] words = c.split(" ");
	    String result = "";
	    for(String w : words){
	        result += (w.length() > 1? w.substring(0, 1).toUpperCase() + w.substring(1, w.length()).toLowerCase() : w) + " ";
	    }
	    return result.trim();
	}
	
	// re-format the output: upperCase some fields
	public String upperCaseField(String field)
	{
		ArrayList<String> upperCase = new ArrayList<String>();
		upperCase.add("mã số");
		upperCase.add("phòng");
		upperCase.add("phòng học");
		upperCase.add("ngày");
		upperCase.add("ngày học");
		upperCase.add("tiết bắt đầu");
		upperCase.add("tiết bắt đầu học");
		
		if (field.equals("sinh viên"))
		{
			return capitalize(this.getField(field));
		}
		else
		{
			if (upperCase.contains(field))
				return this.getField(field).toUpperCase();
		}
		return this.getField(field);
	}//end upperCaseField function
}//end Student class 
