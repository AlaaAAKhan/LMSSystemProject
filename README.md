/*
* Alaa Khan
* CEN 3024C - 13950 - Software Development 1
* September 8, 2025
*/  

This is a library management system run on the command-line interface (CLI). It is for the users- the librarian(s)- to use based on information given by the patrons. 
It will not only keep track of regular and non-regular visitors of the library, but also keep records of patrons’ dues and late fees associated with their information as a patron. 
Along with the abovementioned fines, this information consists of providing each patron with a unique 7-digit ID number, the patron’s name, and address. This system will allow the 
library to establish a secure, organized system to handle the sensitive customer data in a list that can be accessed by a menu. 

This project creates a Patron object and organizes them into an ArrayList. The menu is operated as a switch statement and the chosen option calls the required function (add, display, 
remove, or quit). 
When adding a patron, they can be added either manually from the CLI or by a text file upload. The manual option asks users for each of the Patron's attributes and then creates that 
Patron object. For the fines and ID, a checker method is used to make sure the fines are within a range of 0 and 250, and that the ID is all digits and has a length of 7. If the 
requirements are not met, an error is given to the user and they are prompted to enter again.

For displaying the patrons, they are formatted as follows: "ID | Name | Address | Fines". 

For removing a patron, the user is prompted to enter the ID of the patron to be removed. The system then searches through the list until the patron with that ID is found and removes 
them. If the end of the list is reached and that ID did not exist in the system, an error is given and the user is prompted to enter an ID again.

