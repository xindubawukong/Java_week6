package dataChooser;

import java.io.*;

public class Test {
	public static void main(String[] args)throws FileNotFoundException{
		DataChooser chooser=new DataChooser();
		chooser.init("data.txt");
		chooser.doit();
		chooser.outit("newData.txt");
	}
}