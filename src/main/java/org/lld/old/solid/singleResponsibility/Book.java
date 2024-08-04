package org.lld.old.solid.singleResponsibility;

public class Book {
    private String bookName;
    private String author;
    private String text;

    public boolean findByAuthor(String authName) {
        return author.contains(authName);
    }
    public boolean findByName(String bookName){
        return bookName.contains(bookName);
    }

//    //Printing it on Console
//    //We should have a seperate book printer or logger or emails
//    void printTextToConsole(){
//
//    }

}
//SOLUTION
class BookPrinter {
    //method for outputting text
    void printTextToConsole(String text){

    }
    //Share text to other medium like logger, Email
    void shareTExtToOtherMEdium(String text){

    }
}
