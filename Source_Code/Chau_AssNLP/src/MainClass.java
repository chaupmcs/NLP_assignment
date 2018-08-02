import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;

public class MainClass {

	public static List<String> readInputFile()
	{
		List<String> raw_input_list = new ArrayList<String>();
		Scanner fileScanner;
		try 
		{
			fileScanner = new Scanner(new File("input.txt"), "UTF-8");
			while (fileScanner.hasNextLine())
			{
				raw_input_list.add(fileScanner.nextLine());
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
		
		return raw_input_list;
	}
	
	public static void writeFile(String output)
	{
		try
		{
		    PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		    writer.println(output);
		    writer.close();
		} catch (IOException e) 
		{
		   // do something
		}
	}
		
	//check if a student is satisfy the conditions.
	public static boolean isSatisfyConditionFields(Student student, Map<String, String> condition_fields)
	{
		//boolean is_satisfy = false;
		for (Map.Entry<String, String> entry : condition_fields.entrySet())
		{
		    if (!student.getField(entry.getKey()).equals(entry.getValue()))
		    {
		    	return false;
		    }
		}
		return true;
	}
	
	//get all the query fields:
	public static String getQueryFields(Student student, List<String> query_fields)
	{
		String output="";//store the output
		int count = 0;//help to print "; " format, this's frivolous, just formating.
		for (String a_query : query_fields)
		{
			count++;
			output += student.upperCaseField(a_query);
			if (count < query_fields.size() )//if it has another field, print "; " to make a separation
				 output += "  ";
		}
		return output;
	}
		
	public static void main(String[] args) throws Exception 
	{
		List<String> input_string_list;
		input_string_list = readInputFile();
		String string_write_file = "";//store the string to write 'output.txt' file
	
		int count_the_number_of_inputrow = 0;//not important, just for formating
		
		System.out.println("***************************");
		System.out.println("Full name: Chau Pham Minh");
		System.out.println("Student ID: 51300366");
		System.out.println("***************************");
		string_write_file += "***************************" + "\n" + "Full name: Chau Pham Minh" + "\n" +
							"Student ID: 51300366" + "\n" + "***************************" + "\n" ;
		
		for (String input_raw  : input_string_list)
		{
			count_the_number_of_inputrow++;
			//first of all, convert all the input to lowerCase
			String input_string = input_raw.toLowerCase();
			
			//take it into ANTLR:
			ANTLRInputStream input = new ANTLRInputStream(input_string);
			List<Student> lstStudent = CreateDataBase.createDataBase();
			StudentLexer lexer = new StudentLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			tokens.fill();
						
			System.out.println("========= Processing the input " + count_the_number_of_inputrow + "... =========");
			System.out.println("The input is : " + input_raw);
			System.out.println("---------------------");
			string_write_file += "========= processing the input " + count_the_number_of_inputrow + "... =========" + "\n" +
					"The input is : " + input_raw + "\n" + "---------------------" + "\n" ;
			
			List<Parse> list_Parse = new ArrayList<Parse>(); //store  parse element
			for (Token token : tokens.getTokens() )
			{
				if (token.getType() != -1) //if token is not EOF
				{ 
					String rule = lexer.getRuleNames()[token.getType() - 1];//ex: "STUDENT";
					String text = token.getText();//ex: "sinh viên"
					System.out.println(rule + " : " + text);
					string_write_file += rule + " : " + text + "\n";
					list_Parse.add(new Parse(rule, text));
				}			
			}//end for
			
			System.out.println("---------------------");
			string_write_file += "---------------------" + "\n";
			Map<String, String> condition_fields = new HashMap<String, String>();
			List<String> query_fields = new ArrayList<>();	
			boolean is_searching_failed = false; //used when CONDITION_NOT_FOUND happened
					// ex: "sinh viên nào có mã số MT999999" => student ID is not found => CONDITION_NOT_FOUND.
			for (Parse parse_element : list_Parse)
			{
				if (parse_element.rule.equals("CONDITION_NOT_FOUND"))
				{
					System.out.println("CONDITIONS are not satisfied !");
					string_write_file += "CONDITIONS are not satisfied !" + "\n"; 
					is_searching_failed = true;
					break;
				}
				else
				{
					if (parse_element.rule.equals("WHQUERY"))
					{
						parse_element.text = parse_element.text.replace(" nào", "");
						parse_element.text = parse_element.text.replace("mấy ", "");
						parse_element.text = parse_element.text.replace(" mấy", "");
						query_fields.add(parse_element.text);
					}
					else
					{
						if (parse_element.rule.equals("WHQUERY_BEGIN_CLASS"))
						{
							query_fields.add("tiết bắt đầu");
						}
						else
						{
							List<String> condition_keywords = new ArrayList<String>();
							condition_keywords.add("mã số");
							condition_keywords.add("sinh viên");
							condition_keywords.add("phòng học");
							condition_keywords.add("phòng");
							condition_keywords.add("môn học");
							condition_keywords.add("môn");
							condition_keywords.add("ngày học");
							condition_keywords.add("ngày");
							condition_keywords.add("tiết bắt đầu học");
							condition_keywords.add("tiết bắt đầu");
							condition_keywords.add("số tiết học");
							condition_keywords.add("số tiết");
							
							for (String condition_element : condition_keywords)
							{
								if (parse_element.text.contains(condition_element) && condition_element.length()<parse_element.text.length())
								{
									String value = parse_element.text.replace(condition_element + " ", "");
									
									//delete the space (" ") at the end if it has (not important, just for formating)
									String last_element = Character.toString(value.charAt(value.length()-1));
									if (last_element.equals(" "))
									{
										value = value.substring(0, value.length()-1);
									}//end space format
									
									// append (condition_key, value)  to conditions_fields
									condition_fields.put(condition_element, value);
									break;
								}
							}//end inner-for
						}//end inner-else
					}//end outer-else
				}// end outermost-else
			}//end outer-for
			
			if (!is_searching_failed)
			{
				System.out.println("Condition_fields: "+ condition_fields);
				System.out.println("Query_fields: "+ query_fields);
				
				System.out.println("---------------------");
				System.out.println("The output: ");
				
				string_write_file += "Condition_fields: "+ condition_fields + "\n" +
									"Query_fields: "+ query_fields + "\n" +
									"---------------------" + "\n" +
									"The output: " + "\n";
				List<String> list_output = new ArrayList<String>();
				String output = "";
				for (Student student : lstStudent)
				{
					if (isSatisfyConditionFields(student, condition_fields))
					{
						output = getQueryFields(student, query_fields);
						if (!list_output.contains(output))
							list_output.add(output);
					}
				}
				System.out.println(list_output);
				string_write_file += list_output + "\n";
			}
			else
			{
				System.out.println("NO RESULT !");
				string_write_file += "NO RESULT !" + "\n";
			}
			
			System.out.println("============== end the input "+ count_the_number_of_inputrow + " ==============\n");
			string_write_file += "============== end the input "+ count_the_number_of_inputrow + " ==============\n" + "\n";
			
			/*'bien dich va truy van' section:*/
			//(if have enough time)
			//TODO
		}
		System.out.println("============================== END THE OUTPUT ==============================");
		string_write_file += "============================== END THE OUTPUT ==============================";
		writeFile(string_write_file);//write report to 'output.txt' file
	}//end main function
}//end the class
