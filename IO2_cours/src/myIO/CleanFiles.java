package myIO;

//Pour saisir le caractère tilde (~) sous Mac OS : Alt + n.

import java.io.File;
import java.io.FilenameFilter;

public class CleanFiles implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if (name.charAt(name.length() - 1) == '~') {
			return true;
		} else {
			return false;
		}
	}

	public static void deleteFilesInFolder(String name) {
		// CleanFiles filter = new CleanFiles();
		File dir = new File(name);
		System.out.println(dir.getAbsolutePath());

		if (dir.isDirectory()) {
			File[] fichiers = dir.listFiles(/* filter */);
			for (int i = 0; i < fichiers.length; i++) {
				fichiers[i].delete();
			}
		}
	}

	public static void afficherFilesInFolder(String name) {
		// CleanFiles filter = new CleanFiles();
		File dir = new File(name);

		if (dir.isDirectory()) {
			File[] fichiers = dir.listFiles(/* filter */);
			for (int i = 0; i < fichiers.length; i++) {
				System.out.println(fichiers[i].getName().toString());
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * String name = "MyFiles3"; afficherFilesInFolder(name);
		 * deleteFilesInFolder(name); afficherFilesInFolder(name);
		 */

		CleanFiles filter = new CleanFiles();
		File dir = new File(args[0]);
		if (dir.isDirectory()) {
			File[] fichs = dir.listFiles(filter);
			for (int i = 0; i < fichs.length; i++) {
				fichs[i].delete();
			}
		}
	}

}
