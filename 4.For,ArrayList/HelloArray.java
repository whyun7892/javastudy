
import java.util.ArrayList;
import java.lang.String;

class UserInfo {
	String name;
	String passwd;
	int age;

	public UserInfo(String _name, String _passwd, int _age)
	{
		name=_name;
		passwd=_passwd;
		age=_age;
	}
}

public class HelloArray {

	public static void main(String[] args)
	{
		ArrayList<UserInfo> list=new ArrayList<UserInfo>();
		int i=0;


		list.clear();
		if(list.isEmpty())
		{
			System.out.println("It's empty");
		}

		for(i=0; i<10; i++)
		{
			String name=String.format("name%d", i);
			UserInfo ui=new UserInfo(name, "passwd", i);
			list.add(ui);
		}

		for(i=0;i<list.size();i++)
		{
			System.out.print(list.get(i).name);
			System.out.println("");
		}

	}
}
