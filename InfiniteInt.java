/*
Programmer: Brandon Evans
Date: 4/21/2020
Description: Build int of any length

Disclaimer:
The given assignment description, project files, code files and/or solution files
should not be made available in a public form via methods such as online hosting
in code repositories, educational resource hosting websites, etc. such as Course
Hero and/or Chegg. Tracking information is embedded into the assignment files and
any person found to be distributing files may be prosecuted. This includes
notification to the college, any discipline it warrants and legal action if
it is warranted.
*/
import java.lang.String;
public class InfiniteInt<E> extends DLList implements Comparable{                                                       //extending DLList for methods and implementing Comparable for
    public InfiniteInt() {                                                                                              //default constructor inputs 0
        addLast(0);
    }
    public InfiniteInt(String linkBuild){                                                                               //parameterized constructor
            boolean anyLetters = linkBuild.matches(".*[a-zA-Z]+.*");                                              //checks for any letters that would cause an error

            if (anyLetters == true){
                throw new IllegalArgumentException("Invalid data type at input.");                                      //throw error
            }

        double lengthOfInput = linkBuild.length() % 3;                                                                  //double of length mod 3
        int lengthOfInputDivided = linkBuild.length() / 3;                                                              //use int division to create an int

        if (lengthOfInput == 0){                                                                                        //mod 0 means 3 digits
            for (int i = 0; i < lengthOfInputDivided; i++) {
                String substr = linkBuild.substring(0, 3);                                                              //makes substring of the first 3 digits
                int parsedString = Integer.parseInt(substr);                                                            //make into int
                addFirst(parsedString);                                                                                 //add integers to the front of DLL
                linkBuild = linkBuild.substring(3);                                                                     //reset substring
            }
        }

        else if (lengthOfInput == 1){                                                                                   //mod 1 for length of 1
            String substr = linkBuild.substring(0,1);                                                                   //get substring
            int parsedString = Integer.parseInt(substr);                                                                //make substr into int
            addFirst(parsedString);                                                                                     //adds to front
            linkBuild = linkBuild.substring(1);                                                                         //reset substring
            for (int i = 0; i < lengthOfInputDivided; i++){                                                             //copy code from length 3
                substr = linkBuild.substring(0, 3);
                parsedString = Integer.parseInt(substr);
                addFirst(parsedString);
                linkBuild = linkBuild.substring(3);
            }
        }

        else if (lengthOfInput == 2){                                                                                   //mod 2 for length of 2
            String substr = linkBuild.substring(0,2);                                                                   //get substring
            int parsedString = Integer.parseInt(substr);                                                                //make into int
            addFirst(parsedString);                                                                                     //adds to front
            linkBuild = linkBuild.substring(2);                                                                         //reset substring
            for (int i = 0; i < lengthOfInputDivided; i++){                                                             //copy code from length 3
                substr = linkBuild.substring(0, 3);
                parsedString = Integer.parseInt(substr);
                addFirst(parsedString);
                linkBuild = linkBuild.substring(3);
            }
        }
    }

    public static InfiniteInt add(InfiniteInt int1, InfiniteInt int2) {
        DLList<Integer> outList = new DLList<Integer>();                                                                      //make new list to add into
        DLLNode<Integer> ptr1 = int1.head;                                                                              //make pointers 1 and 2 for add subjects
        DLLNode<Integer> ptr2 = int2.head;
        int numberToReturn = 0;
        int remainder = 0;
        String output = "";                                                                                             //final output

        if (int1.size() == int2.size()) {                                                                               //ints of the same length, no remainder
            while (ptr1 != null) {
                outList.addFirst(ptr1.data + ptr2.data);                                                                //add pointers
                ptr1 = ptr1.next;                                                                                       //move pointer
                ptr2 = ptr2.next;
            }
        }

        else if (int1.size() > int2.size()) {                                                                           //if int1 is bigger than int2
            while (ptr1 != null) {
                ptr1.data += remainder;                                                                                 //add remainder, only can occur after 1 iteration
                remainder = 0;                                                                                          //reset remainder if it was added
                if (ptr2 != null) {                                                                                     //while ptr2 sees data
                    numberToReturn = ptr1.data + ptr2.data;                                                             //keep adding to ptr1
                    ptr2 = ptr2.next;                                                                                   //move pointer
                }
                else if (ptr2 == null)                                                                                  //when ptr2 runs out of data
                    numberToReturn = ptr1.data;                                                                         //return ptr1
                if (numberToReturn > 999) {                                                                             //if ptr1 is > 1000, has remainder
                    remainder = (numberToReturn - (numberToReturn % 1000)) / 1000;                                      //create remainder
                    numberToReturn = numberToReturn % 1000;                                                             //return without remainder
                }
                outList.addFirst(numberToReturn);                                                                       //add final to DLList
                ptr1 = ptr1.next;                                                                                       //move pointer
            }
        }

        else if (int1.size() < int2.size()) {                                                                           //if int2 is bigger than int1
            while (ptr2 != null) {                                                                                      //same code as case above, changed ptr name
                ptr2.data += remainder;
                remainder = 0;
                if (ptr1 != null) {
                    numberToReturn = ptr1.data + ptr2.data;
                    ptr1 = ptr1.next;
                }
                else if (ptr1 == null)
                    numberToReturn = ptr2.data;
                if (numberToReturn > 999) {
                    remainder = (numberToReturn - (numberToReturn % 1000)) / 1000;
                    numberToReturn = numberToReturn % 1000;
                }
                outList.addFirst(numberToReturn);
                ptr2 = ptr2.next;
            }
        }

        output = outList.toString().replaceAll(",", "")                                                                 //remove commas
                .replaceAll("[\\p{Ps}\\p{Pe}]", "").replaceAll(" ", "");                                                //remove any other bad characters
        return new InfiniteInt(output);
    }

    @Override
    public int compareTo(Object o) {
        try {

        if (o instanceof InfiniteInt) {                                                                                 //test if input is InfiniteInt
            InfiniteInt that = new InfiniteInt(reverseString(((InfiniteInt) o).revAndRemoveToString()));                //make into InfInt called that
            DLLNode<Integer> ptr1 = this.head;
            DLLNode<Integer> ptr2 = that.head;
            if (this.size() > that.size()) {                                                                            //if the first is larger
                return 1;
            } else if (this.size() < that.size()) {                                                                     //if the second is larger
                return -1;
            } else {                                                                                                    //if they are the same length
                while (ptr1 != null) {                                                                                  //while ptr1 has data
                    if (ptr1.data > ptr2.data) {                                                                        //if first node of ptr1 is bigger
                        return 1;                                                                                       //return 1
                    } else if (ptr1.data < ptr2.data) {                                                                 //if first node of ptr2 is bigger
                        return -1;                                                                                      //return -1
                    } else {                                                                                            //if they are the same
                        ptr1 = ptr1.next;                                                                               //move to next set until they aren't the same
                        ptr2 = ptr2.next;
                    }
                }
                return 0;                                                                                               //if gets to here, same number
            }
        }

        return 0;
            }catch (Exception e){                                                                                       //exception if nothing works
                return 0;
            }
        }

    public String revAndRemoveToString() {
        String linkBuild = reverseString(String.valueOf(this));                                                         //call reverse methodseen below
        linkBuild = linkBuild.replaceAll(",","");                                                       //replace commas and spaces
        return linkBuild.replaceAll(" ","");
    }

    public String reverseString(String linkBuild){
        String outputString = "";

        for (int i = linkBuild.length()-1; i > -1; i--){                                                                //go through string in reverse
                outputString += linkBuild.charAt(i);                                                                    //make a new string to hold the string backwards
        }

        return outputString;
    }

    public String toString() {
        String outString = "";
        DLLNode<E> ptr = tail;

        while (ptr != null) {                                                                                           //while node has something
            if (ptr == null)                                                                                            //return nothing if empty
                return "";
            else {
                if (ptr != tail) {                                                                                      //if not the tail
                    if(String.valueOf(ptr).length() == 1){                                                              //if it only has one number
                        outString += "," + "00" + ptr.data;                                                             //add two zeroes and comma
                        ptr = ptr.prev;                                                                                 //move pointer
                    }
                    else if(String.valueOf(ptr).length() == 2){                                                         //if two numbers
                        outString += "," + "0" + ptr.data;                                                              //add one zero and a comma
                        ptr = ptr.prev;                                                                                 //move pointer
                    }
                    else {
                        outString += "," + ptr.data;                                                                    //otherwise add comma
                        ptr = ptr.prev;                                                                                 //move pointer
                    }
                }
                else{
                        outString += ptr.data;                                                                          //if it is the tail, just add it
                        ptr = ptr.prev;                                                                                 //move pointer
                }
            }
        }

        return outString;
    }

    public String replaceCommasWithHyphens() {
                                                                                                                        //replaces all commas with hyphens
        return String.valueOf(this).replaceAll("," , "-");
    }
    public String getGraderHash()
    {
        return "203077029c6aba3738008087c55154b0";
    }
}