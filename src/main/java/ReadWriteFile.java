/*

SCRAP CODE


import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.ietf.jgss.GSSContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadWriteFile {

    public static void main(String[] args) throws IOException {


        boolean previousBookFilePresent = false;

        //create Gson doohickey
        Gson gson = new GsonBuilder().create();


        //create a new file to hold our JSON
        File bookFile =  new File("book.json");
        //Commons-IO dependency, converts bookFile into a java-readable file and converts it to string

        //converts bookFile to jsonString
        String jsonBookString = FileUtils.readFileToString(bookFile);

        //parses jsonString
        JsonElement jelement = new JsonParser().parse(jsonBookString);
        JsonObject jobject = jelement.getAsJsonObject();


        jobject.addProperty("IsThisCodeAwesome", Boolean.TRUE);

        String resultingJson = gson.toJson(jelement);
        FileUtils.writeStringToFile(bookFile, resultingJson);



        String json = gson.toJson(book);



        //write json to the file
        FileWriter bookFileWriter = new FileWriter(bookFile);
        bookFileWriter.write(json);
        bookFileWriter.close();

        //read json from the file
        Scanner fileScanner = new Scanner(bookFile);
        //set it so the scanner reads to the very end of the file
        fileScanner.useDelimiter("\\Z");
        String contents = fileScanner.next();

        //parse the book json back into a Book object
        Book savedBook = gson.fromJson(contents, Book.class);

        System.out.println(savedBook);













        //create a scanner for user input
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to File-I/O-graphy.");

        //Prompt for book title
        System.out.println("Enter book title:");
        //the object bookTitle will contain whatever the user inputs next
        String bookTitle = userInput.next();
        //Print the book title back to reader
        System.out.println(bookTitle);

        System.out.println("Enter author name:");
        String authorName = userInput.next();

        System.out.println("Enter book genre:");
        String bookGenre = userInput.next();


        System.out.println("Enter publisher name:");
        String publisherName = userInput.next();

        System.out.println("Enter publish year:");
        //because next() returns a String, we must convert the string to an integer first by passing the result of next()
        //into the valueOf() method
        int yearPublished = Integer.valueOf(userInput.next());

        //close the scanner to keep it from waiting for new input
        userInput.close();

        //now we can pass the variables into book's arguments
        Book book = new Book(bookTitle, authorName, bookGenre, publisherName, yearPublished);

        //convert object to JSON
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(book);

        //create a new file to hold our JSON
        File bookFile =  new File("book.json");

        //write json to the file
        FileWriter bookFileWriter = new FileWriter(bookFile);
        bookFileWriter.write(json);
        bookFileWriter.close();

        //read json from the file
        Scanner fileScanner = new Scanner(bookFile);
        //set it so the scanner reads to the very end of the file
        fileScanner.useDelimiter("\\Z");
        String contents = fileScanner.next();

        //parse the book json back into a Book object
        Book savedBook = gson.fromJson(contents, Book.class);

        System.out.println(savedBook);



    }
}
*/