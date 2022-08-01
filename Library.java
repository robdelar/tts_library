package package1;
 
public class Library {
	
	String address;
	
	int indx = 0;
	
	Book[] books = new Book[4];
	
    public Library(String addr) {
    	this.address = addr;
    }
    
    public void addBook(Book newBook) {
    	books[indx] = newBook;
    	indx = indx + 1;
    } 
    
    public void printAddress() {
    	System.out.println(this.address);
	}
    
    public static void printOpeningHours() {
    	System.out.println("Libraries are open daily from 9am to 5pm.");
    }
    
    public void borrowBook(String book) {
    	int flag = -1;
    
    	for(int i = 0; i < indx; i++) {
    		if(books[i].title.equals(book)) {
    			if(books[i].borrowed == false) {
    				books[i].borrowed = true;
    				flag = 0;
    				System.out.println("You successfully borrowed " + book);
    			} else {
    	    		System.out.println("Sorry, this book is already borrowed");
    			}
    			
    		}
    	}
    	
    	if(flag < 0) {
    		System.out.println("Sorry, this book is not in our catalog.");
    	}
    	
    }
    
    public void printAvailableBooks() {
    	int flag = -1;
    	for(int i = 0; i < indx; i++) {
    		if(books[i] != null) {
	    		if(books[i].borrowed == false) {
	    			flag = 0;
	    			System.out.println(books[i].getTitle());
	    		}
    		}
    	}
    	
    	if (flag < 0) {
    		System.out.println("No book in catalog");
    	}
    }
    
    public void returnBook(String title) {
    	for(int i = 0; i < indx; i++) {
    		if(books[i].title.equals(title)) {
    			if(books[i].borrowed == true) {
    				books[i].borrowed = false;
    				System.out.println("You successfully returned " + title);
    			} 
    		}
    	}
    	
    }
    
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}