
class MultiThread extends Thread {
	String name;
	int age;

	// synchronized 키워드는 member variable에 사용하지 못한다.
	
	public void increment_age() { 
		// 이 함수가 해야 하는 일이 많을 경우, 특정부분만 동기화를 걸수 있다.
		synchronized(this) {
			age++; 
		}
	
	}

	public MultiThread(String name) {
		//getName()함수는 Thread 클래스로부터 나온거임.
		System.out.println(getName() + "Thread has been created");
		this.name=name;
	}

	public void run() {
		for(int i=0;i<50;i++) {
			increment_age();
			System.out.println(getName() + "(" + name + ") : " + age);
			try {
				sleep(100);
			}
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

class MultiThread2 implements Runnable {
	String name;
	int age;

	public synchronized void increment_age() { age++; }
	public MultiThread2(String name) {
		//getName()함수는 Thread 클래스로부터 나온거임.
		System.out.println(Thread.currentThread().getName() + "Thread has been created");
		this.name=name;
	}

	public void run() {
		for(int i=0;i<50;i++) {
			increment_age();
			System.out.println(Thread.currentThread().getName() + "(" + name + ")-- " + age);
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

class MyThread {
	public static void main(String[] args) 
	{
		// Call class that is extended from Thread
		MultiThread mt1=new MultiThread("___T1___");
		MultiThread mt2=new MultiThread("___T2___");
		MultiThread mt3=new MultiThread("___T3___");

		mt1.start();
		mt2.start();
		mt3.start();

		// Call call that has implemented Runnable
		MultiThread2 m2_1=new MultiThread2("[[[M2-1]]]");
		MultiThread2 m2_2=new MultiThread2("[[[M2-2]]]");
		MultiThread2 m2_3=new MultiThread2("[[[M2-3]]]");

		Thread tr1=new Thread(m2_1);
		Thread tr2=new Thread(m2_2);
		Thread tr3=new Thread(m2_3);

		tr1.start();
		tr2.start();
		tr3.start();

	}
}
