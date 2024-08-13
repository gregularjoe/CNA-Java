package Java_2.Assignment3.Validation;
// Fig. 14.20: ValidateInput.java
// Validating user information using regular expressions.

public class ValidateInput {
   // validate first name
   public static boolean validateFirstName(String firstName) {
      return firstName.matches("[A-Z][a-zA-Z]{2,99}");
   }

   // validate last name
   public static boolean validateLastName(String lastName) {
      return lastName.matches("[A-Z][a-zA-Z]*(['-][A-Z][a-zA-Z]*)*");
   } 

   // validate address
   public static boolean validateAddress(String address) {
      return address.matches(
              "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+)");
   }

   // validate city
   public static boolean validateCity(String city) {
      return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
   } 

   // validate state
   public static boolean validateState(String state) {
      return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+)") ;
   }

   // validate zip
   public static boolean validateZip(String zip) {
      return zip.matches("\\d{5}|[ABCEGHJ-NPRSTVXY][0-9][ABCEGHJ-NPRSTV-Z][0-9][ABCEGHJ-NPRSTV-Z][0-9]");
      // I wasn't sure how valid you wanted the match to be to actual Postal Code's so the one above
      // is as close as I could get it based on the rules I found online, but below is my original.
      //
      // [A-Z][0-9][A-Z][0-9][A-Z][0-9]
   }

   // validate phone
   public static boolean validatePhone(String phone) {
      return phone.matches("[0-9]\\d{1}-[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
   }
} 

/*
 **************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************
*/

