package myIO;

import java.io.File;

public class MyFile {

	
	
	public static void main(String[] args) {
		String pathname = ".";
		File f1 = new File(pathname);
		System.out.println("f1 exist? :"+ f1.exists());
		System.out.println(f1.getAbsolutePath());
		
		
		File parent = new File("/Users/anca/workspace/NFA035/IO2_cours");
		String child = "myFile2.txt";
		File f2 = new File(parent, child);
		if (f2.exists()){
			f2.delete();
		}
		System.out.println("f2 exist? :"+ f2.exists());
		System.out.println("Création de répertoire");
		f2.mkdir();
		System.out.println("f2 exist? :"+ f2.exists());
		System.out.println(f2.getAbsolutePath());
	}

}
