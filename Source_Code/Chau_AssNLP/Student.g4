/**
 * Define a grammar for ASS_NLP
 */
grammar Student;

r: whQUERY;
WS : [ \t\r\n]+ -> skip ; // skip some white spaces
whQUERY: WHQUERY;
NAME: 'sinh viên '('phạm văn hai'|'trần anh dũng'|'nguyễn thị mai'|'nguyễn thị trang'|'đỗ thanh hải'|'lê minh trang'|'trần quốc việt'|'đoàn minh thịnh'|'văn bạch mai'|'nguyễn hạnh phúc') ' ';//condition
ROOM: 'phòng '('205/b10'|'402/c6'|);//condition
STUDENT_ID: 'mã số '('mt12001'| 'mt12002'|'mt12003'|'mt12004'|'mt12005'|'mt12006'|'mt1207'|'mt12008'|'mt12009'|'mt12010') ' ';//condition  
V: 'học ';
DATE: ('ngày ' 'học '?) ('t2'|'t4') ' ';//condition
BEGINNING_CLASS: 'tiết bắt đầu '('0'..'9'+);
NUMBER_CLASS: ('0'..'9'+)' tiết';
NLP: 'xử lý ngôn ngữ tự nhiên ';
PPL: 'ngôn ngữ lập trình ';
SUBJECT: 'môn '(NLP|PPL);//condition
WHQUERY: 'môn nào' | 'phòng nào' | 'ngày nào' | 'mấy tiết' | 'sinh viên nào' | 'mã số nào'|'mã số mấy';//question
WHQUERY_BEGIN_CLASS: 'tiết mấy ' | 'tiết nào ' | 'tiết bắt đầu nào '| 'tiết bắt đầu mấy ';//question
QUESTION_MARK: '?';
IN_LOC: 'ở ';
COMMA: ', ' -> skip;
GIVE_QUES: 'hãy cho biết';
STUDENT: 'sinh viên';
BEGIN_CLASS : 'tiết bắt đầu';
HAVE: 'có ';
CONDITION_NOT_FOUND: ('sinh viên ' ~['có''học']) | 'mã số '| ('môn ' ('học '?)) | ('phòng ' ('học '?)) | ('ngày ' ('học '?)) | ('tiết bắt đầu ' ('học '?) ~['là''từ']) | ('số tiết ' ('học '?));
OTHER_WORDS: (.*?' ' | (.*?('?'|'.')) ); //skip everything else

/*end of the file*/
