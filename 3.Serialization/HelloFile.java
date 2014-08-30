

/*
 * 참고한 사이트: http://cremazer.blogspot.kr/2013/09/java-serialization.html
 */



import java.io.IOException;
import java.util.ArrayList;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;

// 새로운 class가 public으로 선언되면 반드시 다른 파일로 분리가 되어야 함.
// 해당 파일의 이름은 class의 이름과 같아야 함.
// public class UserInfo implements java.io.Serializable {
class UserInfo implements java.io.Serializable {
	String name;
	String password;
	int age;

	// 생성자는 public 등이 붙지 않는다.
	public UserInfo(String _name, String _passwd, int _age)
	{
		name=_name;
		password=_passwd;
		age=_age;
	}

	public void printName()
	{
		System.out.println(this.name);
	}
	public void printPasswd()
	{
		System.out.println(this.password);
	}
}



// main 함수는 반드시 static 으로 선언되어야 하며,
// 같은 class 내에서는 static member variable과 function만 호출할 수 있다.
public class HelloFile {

	static String strFname="archive.ser";

	public static UserInfo readUserInfo()
	{
		try {
			UserInfo ui;

			FileInputStream fis=new FileInputStream(strFname);
			BufferedInputStream bis=new BufferedInputStream(fis);
			ObjectInputStream in=new ObjectInputStream(bis);

			ui=(UserInfo)in.readObject();
			in.close();

			return ui;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void writeUserInfo(UserInfo UI)
	{
		try {


			FileOutputStream fos=new FileOutputStream(strFname);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			ObjectOutputStream out=new ObjectOutputStream(bos);


			System.out.print("Writing to file");
			out.writeObject(UI); System.out.print("......");
			out.close();
			System.out.println("writing completed!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		try {

			String strFname="archive.ser";
			UserInfo ui1=new UserInfo("미미","mimi's 비번", 41);

			ArrayList<UserInfo> list=new ArrayList<UserInfo>();


			//여러개의 데이터를 저장할 때에는 list로 만들어서 저장하고, 읽어들이면 된다. 근데 읽어들일때 list를 읽어들이진 못하는가 보다. 하나씩 읽어서 list에 박는구나..
			list.add(ui1);


			System.out.println("Press any key to start writing file");
			System.in.read();
			writeUserInfo(ui1);

			System.out.println("Press any key to read from file");
			UserInfo ui2=readUserInfo();
			ui2.printName();
			ui2.printPasswd();



		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
