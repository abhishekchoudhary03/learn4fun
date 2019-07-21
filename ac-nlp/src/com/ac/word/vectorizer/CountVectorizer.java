/**
 * 
 */
package com.ac.word.vectorizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author abhishek.choudhary
 * Counting the number of times each word appears in a document.
 */
public class CountVectorizer {
	public Scanner fetchDocument(String path) {
		try {
		File file = new File(path); 
		Scanner sc = new Scanner(file);
	    	sc.useDelimiter(" ");
//	    	System.out.println(sc.next()); 
	    	if (sc.hasNext()) return sc;
	    	sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, Integer> createVectorMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Scanner sc = new CountVectorizer().fetchDocument("target/document/doc1.txt");
		if (sc != null) {
			while (sc.hasNext()) {
				String key = sc.next().replaceAll("\\p{Punct}", "");
				if (map.get(key) == null) {
					map.put(key, 1);
				} else {
					map.put(key, map.get(key)+1);
				}
			}
		}
		return map;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new CountVectorizer().fetchDocument("target/document/doc1.txt");
//		if (sc != null)
//			while (sc.hasNext())
//				System.out.print(sc.next().replaceAll("\\p{Punct}", "") + " "); 
		Map<String, Integer> vectorMap = createVectorMap();
		vectorMap.forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
