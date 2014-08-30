
import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;


interface TopTree 
{
	public void SayTop();
}

interface SecondTree extends TopTree
{
	public void SaySecond();
}

// Interface들을 implements할 때에는 모든 함수들에 대해서 body를 구현해줘야 한다.
class Tree implements SecondTree {

	public void SaySecond()
	{
		//...
	}

	public void SayTop()
	{

	}

}

abstract class UserInfo {
	String name;
	String passwd;
	Tree tree;
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

public class HelloInterface {

	public static void main(String[] args)
	{
		try 
		{
			Scanner sc=new Scanner(System.in);
			ArrayList<StupidUserInfo> list=new ArrayList<StupidUserInfo>();
			int i=0;


			list.clear();
			if(list.isEmpty())
			{
				System.out.println("It's empty");
			}

			String name;
			int data;
			for(i=0; i<2; i++)
			{
				System.out.println("Type name"); 	name=sc.nextLine();
				System.out.println("Type age"); 	data=sc.nextInt(); sc.nextLine();

				StupidUserInfo ui=new StupidUserInfo(name, "passwd", data);
				list.add(ui);
			}

			for(i=0;i<list.size();i++)
			{
				System.out.print(list.get(i).name);
				System.out.println("");
			}

		}
		catch(ArithmeticException ae)
		{
			System.out.println("ARITHMETIC ERROR : "+ae);
		}
		catch(java.util.InputMismatchException ie)
		{
			System.out.println("Input Error : "+ie);
		}
		finally
		{
			System.out.println("Shutting down");
		}
	}
}
