# Look Inna Book

## Installation and Usage:

1. Download and install MySQL Workbench.
2. Download and install IntelliJ IDE
3. Download and unzip BookStoreDB.
4. Import SQL file named as Dump.sql in MySQL Workbench, database.
5. Run the program from Driver.
6. The program first starts with a window asking the user for their email and password.
    - If user has previously registered, they can `Login` with their registered email and password.
    - If it is a new user, they will have to press on the `Register` button which prompts the user to input their first name, last name, email, phone number and password.
7. After the customer logs in, they are shown the books available with the book's ISBN, Title, Publisher, Price, Author, Genre and Pages. 
    - The customer can search the book on the search box using any of the key words from the title of the book.
    - The customer should select the book add press the button `Add to Cart` which shows a confirmation window.
8. After the customer is done shopping, they can 'View Cart' and see the books they have selected. 
    - From there they can `Remove` any book they select.
    - They can go `Back` to shopping again.
    - Or can `Go for Payment`.

9. Pressing `Go for Payment` will bring a new window which will show the price, ask for Card No., CVV and shipping address.
    - After the customer is done inputting, they can press the `Checkout` button to purchase.
10. If the owner wants to access the bookstore, they should input both their username & password as admin which will show 3 options, `Book MGT`, `View Customers` and `Sale Report`.
    - `Book MGT` brings up the inventory, the books that are available. If the owner wants a book can be `Added` or `Removed` from the inventory
    - `View Customers` shows the registered customers with their email and password.
    - `Sale Report` brings a window prompting the user for genre or author name, inputting the required information show the total sale and the total amount sold for the author or genre.

## Missing Implementation:

1. Order number tracking.
2. Sales vs Expenditure in report.
3. Automatic order placement.

## Contributor: Sabah Samwatin