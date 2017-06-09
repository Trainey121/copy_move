package copyandmove;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyAndMove {
	// to write to the file enter "bs"
	public static void write(byte[] bs, String command, String inPath, String outPath) { // Path file passing
		//													// through dir
		String[] dirs = outPath.split("\\\\");
		String d = "";
		for (int i = 0; i < dirs.length - 1; i++) {
			d += dirs[i] + "\\";
		}
		Path p = Paths.get(d);
		try { // use the Try_Catch method.... Set the outPath to "rw"
			Files.createDirectories(p);
			RandomAccessFile f = new RandomAccessFile(outPath, "rw");
			f.write(bs); // passing btyes to in orders to write
			if (command.equals("mv") ) {
				delete(inPath);
			}
			f.close();
			

		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {

			System.out.println(ex);
			return;
		}
	}
	public static void delete(String src) {
		File f = new File (src);
		f.delete();
	}
	
	public static void main(String[] args) {
		System.out.println(args.length);
		String command = args[0];
		String inFilePath = args[1]; // Passing args 1 located = *
										// Run_Config_Arguemnt
		String outFilePath = args[2]; // Passing args 2
		byte[] buf = new byte[100];
		byte[] data = null;
		int dataIdx = 0;
		try {
			RandomAccessFile f = new RandomAccessFile(inFilePath, "rw");
			data = new byte[(int) f.length()];
			while (true) {
				int nBytes = f.read(buf);
				if (nBytes == -1) {
					break;
				}
				for (int i = 0; i < nBytes; i++) {
					data[dataIdx] = buf[i];
					dataIdx++;
				}
			}
			f.close();
		} catch (IOException ex) {
			System.out.println(ex);
			return;
		}
		Charset cs = Charset.forName("UTF-8");
		String s = new String(data, cs);
		System.out.println(s);
		CopyAndMove.write(data, command, inFilePath, outFilePath);
	}

}