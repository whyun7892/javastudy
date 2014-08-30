
import java.util.ArrayList;
import java.lang.String;

abstract class UserInfo {
	String name;
	String passwd;
	int age;

	public UserInfo(String _name, String _passwd, int _age)
	{
		name=_name;
		passwd=_passwd;
		age=_age;
	}

	abstract void printUserInfo();
}

class StupidUserInfo extends UserInfo {

	public StupidUserInfo(String _name, String _passwd, int _age)
	{
		// 상속시, 부모 클래스의 생성자를 호출할수는 없네?
		// UserInfo(_name, _passwd, _age);
		// C#에서는 base 함수를 사용함
		super(_name, _passwd, _age);
		
	}
	public void printUserInfo()
	{
		System.out.println("Stupid User:"+name);
	}

}

public class HelloAbstractClass {

	public static void main(String[] args)
	{
		ArrayList<StupidUserInfo> list=new ArrayList<StupidUserInfo>();
		int i=0;


		list.clear();
		if(list.isEmpty())
		{
			System.out.println("It's empty");
		}

		for(i=0; i<10; i++)
		{
			String name=String.format("name%d", i);
			StupidUserInfo ui=new StupidUserInfo(name, "passwd", i);
			list.add(ui);
		}

		for(i=0;i<list.size();i++)
		{
			System.out.print(list.get(i).name);
			System.out.println("");
		}

	}
}
