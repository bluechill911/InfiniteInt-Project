/*
Programmer: Brandon Evans
Date: 4/21/20
Description: null
*/


// Disclaimer:
// The given assignment description, project files, code files and/or solution files
// should not be made available in a public form via methods such as online hosting
// in code repositories, educational resource hosting websites, etc. such as Course
// Hero and/or Chegg. Tracking information is embedded into the assignment files and
// any person found to be distributing files may be prosecuted. This includes
// notification to the college, any discipline it warrants and legal action if
// it is warranted.

// Linked list is DOUBLE linked

public class InfiniteIntSkeleton<Integer> extends DLList
{
	public DLList<Integer> InfiniteInt = new DLList<Integer>(linkBuild);

	//Constructor to build the linked list given a string
	public InfiniteInt(String linkBuild)
	{
		numberList.addLast(0);
	}

	//Constructor that builds a linked list that contains a zero (just empty)
	public InfiniteInt()
	{
		try
		{
			int testS = (int)Double.parseDouble(linkBuild);
		}

		catch (IllegalArgumentException e)
		{
			System.out.println("Illegal, not an int input.");
		}

		double lengthOfInputDouble = (linkBuild.length() % 3);
		int lengthOfInputInt = (linkBuild.length() / 3);

		if (lengthOfInputDouble == 0)
		{
			for (int i = 0; i < lengthOfInputInt; i++)
			{
				String substr = linkBuild.substring(0,3);
				int parsedString = (int)Double.parseDouble(substr);
				numberList.addFirst(parsedString);
				linkBuild = linkBuild.substring(3);
			}
		}
		else if (lengthOfInputDouble == 1)
		{
			String substr = linkBuild.substring(0,1);
			int parsedString = (int)Double.parseDouble(substr);
			numberList.addFirst(parsedString);
			linkBuild = linkBuild.substring(3);

			for (int i = 0; i < lengthOfInputInt; i++)
			{
				substr = linkBuild.substring(0,3);
				parsedString = (int)Double.parseDouble(substr);
				numberList.addFirst(parsedString);
				linkBuild = linkBuild.substring(3);
			}
		}
		else if (lengthOfInputDouble == 2)
		{
			String substr = linkBuild.substring(0,2);
			int parsedString = (int)Double.parseDouble(substr);
			numberList.addFirst(parsedString);
			linkBuild = linkBuild.substring(3);

			for (int i = 0; i < lengthOfInputInt; i++)
			{
				substr = linkBuild.substring(0,3);
				parsedString = (int)Double.parseDouble(substr);
				numberList.addFirst(parsedString);
				linkBuild = linkBuild.substring(3);
			}
		}
	}

	//toString method for String representation of the int without spaces, but commas, OVERRIDES the toString in DLList
	public String toString()
	{
		return null;
	}

	//static add method that receives two InfiniteInts and adds them into a new InfiniteInt() with the total ##Remove a zero?
	public static InfiniteInt add(Object infInt1,Object infInt2)
	{
		return null;
	}

	//a compareTo that implements the Comparable interface: 1 greater -1 lesser 0 same
	public String reverse(String toReverse)
	{
		return null;
	}

	//a replaceCommasWithHyphens method that replaces the commas with hyphens
	public String replaceCommasWithHyphens(String replaceInt)
	{
		return null;
	}


	public String getGraderHash()
	{
		return "203077029c6aba3738008087c55154b0";
	}
}
