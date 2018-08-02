// make the database
// we store the data into a List<Student>
import java.util.ArrayList;
import java.util.List;

public class CreateDataBase
{
	public static List<Student> createDataBase()
		{
			List<Student> lstStudent = new ArrayList<Student>();
		
			lstStudent.add( new Student(//1
					"phạm văn hai", "mt12001", "xử lý ngôn ngữ tự nhiên", "205/b10", "t2", "7", "3") );
			lstStudent.add( new Student(//2
					"trần anh dũng", "mt12002", "ngôn ngữ lập trình", "402/cC6", "t4", "1", "4") );
			lstStudent.add( new Student(//3
					"nguyễn thị mai", "mt12003", "xử lý ngôn ngữ tự nhiên", "205/b10", "t2", "7", "3") );
			lstStudent.add( new Student(//4
					"nguyễn thị trang", "mt12004", "xử lý ngôn ngữ tự nhiên", "205/b10", "t2", "7", "3") );
			lstStudent.add( new Student(//5
					"đỗ thanh hải", "mt12005", "ngôn ngữ lập trình", "402/c6", "t4", "1", "4") );
			lstStudent.add( new Student(//6
					"lê minh trang", "mt12006", "ngôn ngữ lập trình", "402/c6", "t4", "1", "4") );
			lstStudent.add( new Student(//7
					"trần quốc việt", "mt12007", "xử lý ngôn ngữ tự nhiên", "205/b10", "t2", "7", "3") );
			lstStudent.add( new Student(//8
					"đoàn minh thịnh", "mt12008", "xử lý ngôn ngữ tự nhiên", "205/b10", "t2", "7", "3") );
			lstStudent.add( new Student(//9
					"văn bạch mai", "mt12009", "ngôn ngữ lập trình", "402/c6", "t4", "1", "4") );
			lstStudent.add( new Student(//10
					"nguyễn hạnh phúc", "mt12010", "xử lý ngôn ngữ tự nhiên", "205/b10", "t2", "7", "3") );
	
			return lstStudent;
		}//end createDataBase function;
}//end file