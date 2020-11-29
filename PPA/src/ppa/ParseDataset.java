package ppa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseDataset {

	public static void main(String[] args) {
		String out_folder = "/home/islamazhar/eclipse-workspace/PPA/src/examples/BrokenHash/";
		String in_file = "/home/islamazhar/eclipse-workspace/answer_snippets.annotations.csv";
		ParseDataset parseDataset = new ParseDataset();
		parseDataset.generate_code_snippets(in_file, out_folder);
		//String line = "public class SimpleCrypto";
		//String class_name = "class_13";
		//String res = parseDataset.rename_class(line, class_name);
		//System.out.println(res);
	}
	/*
	 * 
	 */
	public String insert_package_name(String line) {
		return "package examples.BrokenHash" + '\n' + line;
	}
	/*
	 * 
	 */
	public String rename_class (String line, String class_name) {
		
		if (line.contains("public") && line.contains("class")) {
			int idx1 = line.indexOf("class") + 6 ;
			int idx2 = line.indexOf(" ", idx1);
			if (idx2 == -1) {
				idx2 = line.length();
			}
			line = line.substring(0,idx1) + class_name + line.substring(idx2, line.length());
		}
		
		return line;
	}
	/**
	 * 
	 * @param line
	 * @return
	 */
	public String sanitize(String line) {
		String [] santize_phrases = {"\"\"", "&lt;", "&amp;",  "&gt;", "@Override", "/././."};
		String [] replacing_phrases = {"\"", "<", "&",  ">", "", " "};
		
		for (int i=0;i< santize_phrases.length; i++) {
			line = line.replaceAll(santize_phrases[i], replacing_phrases[i]);
		}
		
		return line;
	}
	/**
	 * 
	 * @param in_file
	 * @param out_folder
	 */
	public void generate_code_snippets(String in_file, String out_folder) {
		int no = 0;
		String line = "";
		int col_no = 0;
		String start_tag = ",\"";
		String end_tag = "\",";
		int start = 0;
		String class_name = "";
		boolean flag = false;
		String [] patterns = {"AES"};
		//String [] patterns = {"MD5", "SHA1"};
		boolean added_class_name = false;
		try {
			FileWriter array_index = new FileWriter("array_index.txt");
			ArrayList<String> code = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(in_file)); 
			while ((line = br.readLine()) != null) {
				boolean start_code = false;
				boolean end_code = false;
				
				if (line.length() > 2) {
					start_code = line.substring(0,2).equals(start_tag);
					end_code = line.substring(0,2).equals(end_tag);
				}
				if (start_code) {
					start = 1;
					class_name = "class_"+Integer.toString(no+1);
					line = line.substring(2,line.length());
					flag = false;
				}
				else if (end_code) {
					start = 0;
					
					if (code.size() > 0 && flag) {
						FileWriter file = new FileWriter(out_folder+class_name+".java");
						// add the package name the code snippet do not have any package name..
						file.write("package examples.AES; \n");
						
						
						if(!added_class_name) {
							// add the class name the code snippet do not have any class name
							//file.write("public class "+ class_name + "{ \n public static void main() { \n");
							file.write("public class "+ class_name + " { \n");
						}
						
						for(String stmt: code) {
							stmt = this.sanitize(stmt);							
							file.write(stmt+'\n');
							//System.out.println(stmt);
						}
						if(!added_class_name) {
							file.write("\n}");
						}
						file.close();
						array_index.write((no+1)+"\n");
						//System.out.println("==================================================================================");
					}
					no ++;
					added_class_name = false;
					code.clear();
				}
				
				if (start == 1) {
					line = this.sanitize(line);
					if (line.contains("public") && line.contains("class")) {
						line = this.rename_class(line, class_name);
						added_class_name = true;
					}
					if (line.contains("package ")) {
						// just comment out this line since I will be adding my own package..
						line = "// " + line; 
					}
					code.add(line);
					for(String pattern : patterns) {
						if (line.contains(pattern)) {
							flag = true;
						}
					}
				}
			}
			array_index.close();
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created " + no + " code snippets inside " + out_folder + " folder\n"
				+ "from input csv file " + in_file);
	}

}
