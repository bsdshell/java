import java.util.*;
import java.io.*;
import java.util.stream.*;
import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classfile.*;

class Person {
    private int id;
    private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }

}

public class GsonRead {

    private static final String FILENAME = "/Users/cat/myfile/github/java/text/bigjson.txt";
    private static final File file = new File(GsonRead.class.getClass().getResource(FILENAME).getFile());
    private static final InputStream stream = GsonRead.class.getClass().getResourceAsStream(FILENAME);

//	public static void main(String[] args) throws FileNotFoundException, JSONException {
//		String jsonData = "";
//		BufferedReader br = null;
//		try {
//			String line;
//			br = new BufferedReader(new FileReader("/Users/cat/myfile/github/java/text/json.txt"));
//
//			while ((line = br.readLine()) != null) {
//				jsonData += line + "\n";
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null)
//					br.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		// System.out.println("File Content: \n" + jsonData);
//		JSONObject obj = new JSONObject(jsonData);
//		System.out.println("blogURL: " + obj.getString("blogURL"));
//		System.out.println("twitter: " + obj.getString("twitter"));
//		System.out.println("social: " + obj.getJSONObject("social"));
//	}
//
    public static void main(String[] args) {
        long ti, tf;

        ti = System.currentTimeMillis();
        System.out.println("Start reading in object mode: " + ti);
        GsonRead.readDom();
        tf = System.currentTimeMillis();
        System.out.println("Finish. Total time: " + (tf - ti));

        ti = System.currentTimeMillis();
        System.out.println("Start reading in stream mode: " + ti);
        GsonRead.readStream();
        tf = System.currentTimeMillis();
        System.out.println("Finish. Total time: " + (tf - ti));

    }
    public static void readDom() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            Gson gson = new GsonBuilder().create();
            Person[] people = gson.fromJson(reader, Person[].class);

            System.out.println("Object mode: " + people[0]);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GsonRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(GsonRead.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This is a mixed implementation based on stream and object model. The JSON
     * file is read in stream mode and each object is parsed in object model.
     * With this approach we avoid to load all the object in memory and we are only
     * loading one at a time.
     */
    public static void readStream() {
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
            Gson gson = new GsonBuilder().create();

            // Read file in stream mode
            reader.beginArray();
            while (reader.hasNext()) {
                // Read data into object model
                Person person = gson.fromJson(reader, Person.class);
                if (person.getId() == 0 ) {
                    System.out.println("Stream mode: " + person);
                }
                break;
            }
            reader.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GsonRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GsonRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

