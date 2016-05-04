import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Taylor on 5/3/16.
 */
public class BookFileCreator {

    public static void main(String[] args) throws Exception {

        //Create a new instance of Book class
        Book book;

        //create Gson doohickey
        Gson gson = new GsonBuilder().create();

        //Create a new bookFile class and set it to book.json
        File bookFile = new File("book.json");

        //Check to see if bookFile exists already; if it does, then foundExistingJsonFile will return TRUE
        boolean foundExistingJsonFile = bookFile.exists();

        // if foundExistingJsonFile does equal TRUE, then
        if (foundExistingJsonFile == true) {

            //Read JSON file
            Scanner fileScanner = new Scanner(bookFile);

            //set it so the scanner reads to the very end of the file
            fileScanner.useDelimiter("\\Z");

            //put read file contents to string
            String contents = fileScanner.next();

            //Convert (parse) JSON file to book object (overwrite original instance of book object)
            try {

                book = gson.fromJson(contents, Book.class);
                //Print book contents
                System.out.println(book);

            } catch (Exception e) {
                System.out.println("JSON parsing failed.");
            }
        }   //Proceed to prompts

        //Create new Scanner object
        Scanner userInput = new Scanner(System.in);

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

        //Pass inputs into book arguments
        book = new Book(bookTitle, authorName, bookGenre, publisherName, yearPublished);

        //Convert book to JSON file
        try {

            String json = gson.toJson(book);
            //create a new file to hold our JSON
            bookFile = new File("book.json");

            //write json to the file
            FileWriter bookFileWriter = new FileWriter(bookFile);
            bookFileWriter.write(json);
            bookFileWriter.close();
        } catch (Exception e) {
            System.out.println("JSON parsing failed.");
        }

        //read json from the file
        Scanner fileScanner = new Scanner(bookFile);

        //set it so the scanner reads to the very end of the file
        fileScanner.useDelimiter("\\Z");

        String contents = fileScanner.next();

        //parse the book json back into a book object
        try {

        Book savedBook = gson.fromJson(contents, Book.class);
        System.out.println(savedBook);

        } catch (Exception e) {
            System.out.println("JSON parsing failed.");
        }


        int ignoreMe = 1;
    }
}