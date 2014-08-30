import java.io.*;

class FileHandler {

	// FileReader, Writer는 텍스트 파일이 주 대상인듯. 바이너리는 안된다.
	static FileReader reader;
	static FileWriter writer;
	static String Src, Dst;

	static void OpenFiles (String src,String dst) throws IOException 
	{
		Src=src;
		Dst=dst;
		reader=new FileReader(Src);
		writer=new FileWriter(Dst);
	}

	void CloseFiles() throws IOException { reader.close(); writer.close(); }

	public static void writeTxtFile(int ch) throws IOException
	{
		System.out.print(".");
		writer.write((char)ch);
	}

	public static int readTxtFile() throws IOException
	{
		return reader.read();
	}

	public static void main(String[] args) throws IOException {

		int ch;

		if(args.length !=2) { 
			System.out.println("Check Usage"); System.exit(0); 
		}

		OpenFiles(args[0], args[1]);
		while((ch=readTxtFile()) != -1) {
			writeTxtFile(ch);
		}
		writer.close();
	}
}


