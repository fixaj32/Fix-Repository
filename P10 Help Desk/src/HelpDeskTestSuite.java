//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P10 Help Desk
// Files:           SupportTicket, HelpDesk, HelpDeskInterface,
//					HelpDeskTestSuite
// Course:          CS300 Spring 2019
//
// Author:          Andrew Fix
// Email:           afix@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * HelpDeskTestSuite extends HelpDesk and tests methods written in HelpDesk
 * and SupportTicket
 * 
 * @author andrewfix
 *
 */
public class HelpDeskTestSuite extends HelpDesk {

	/**
	 * Constructor for the HelpDeskTestSuite class
	 * 
	 * @param capacity	maximum size of the help desk array
	 */
	public HelpDeskTestSuite(Integer capacity) {
		super(capacity);	// calls the HelpDesk constructor
	}

	/**
	 * Main method of the class which runs all of the tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(testCompareTo());
		System.out.println(testCreateNewTicket());
		System.out.println(testSwap());
		System.out.println(testPropagateUp());
		System.out.println(testPropagateDown());
		System.out.println(testCloseNextTicket());
		System.out.println(testCheckNextTicket());
		System.out.println(testCheckNextTicketEmptyList());
	}
	
	/**
	 * Tests the compareTo method from the SupportTicket class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testCompareTo() {
		SupportTicket test = new SupportTicket("AAA");	// test tickets
		SupportTicket test2 = new SupportTicket("ZZZ");
		// if the first ticket is less than the second
		if(test.compareTo(test2) < 0) 	
			return true;	// test passes
		return false;
	}
	/**
	 * Tests the createNewTicket class from the HelpDesk class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testCreateNewTicket() {
		HelpDesk testDesk = new HelpDesk(10);	// test help desk
		
		testDesk.createNewTicket("fun");	// adds a new ticket
		// if the ticket was added, return true
		if(testDesk.array[0].toString().equals("fun"))
			return true;
		return false;
	}
	/**
	 * Tests the swap method from the HelpDesk class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testSwap() {
		HelpDesk testDesk = new HelpDesk(10);	// test help desk

		testDesk.createNewTicket("cool");	// test tickets
		testDesk.createNewTicket("fun");
		testDesk.swap(0, 1);	// swap the two tickets
		// if the items were successfully swapped, test passes
		if(testDesk.array[0].toString().equals("fun"))
			return true;
		return false;
	}
	/**
	 * Tests the propagateUp method from the HelpDesk class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testPropagateUp() {
		HelpDesk testDesk = new HelpDesk(10);	// test help desk

		testDesk.array[0] = new SupportTicket("basketball");	// test tickets
		testDesk.array[1] = new SupportTicket("baseball");
		testDesk.array[2] = new SupportTicket("hockey");
		testDesk.array[3] = new SupportTicket("footballs");
		

		testDesk.propagateUp(3);	// propagate up the last ticket
		// if the ticket was moved up to the correct spot, test passes
		if(testDesk.array[0].toString().equals("basketball") && 
				testDesk.array[1].toString().equals("footballs") &&
				testDesk.array[2].toString().equals("hockey") && 
				testDesk.array[3].toString().equals("baseball"))
			return true;
		return false;
		
	}
	/**
	 * Tests the propagateDown method from the HelpDesk class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testPropagateDown() {
		HelpDesk testDesk = new HelpDesk(10);	// test help desk

		testDesk.array[0] = new SupportTicket("hockey");	// test tickets
		testDesk.array[1] = new SupportTicket("baseball");
		testDesk.array[2] = new SupportTicket("food");
		
		testDesk.propagateDown(0);	// propagate down the first ticket
		// if the ticket was successfully moved down, test passes
		if(testDesk.array[0].toString().equals("baseball") && 
				testDesk.array[1].toString().equals("hockey") &&
				testDesk.array[2].toString().equals("food"))
			return true;
		return false;
	}
	/**
	 * Tests the closeNextTicket method from the HelpDesk class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testCloseNextTicket() {
		HelpDesk testDesk = new HelpDesk(10);	// test help desk

		testDesk.createNewTicket("pizza");	// test tickets
		testDesk.createNewTicket("cool");
		testDesk.createNewTicket("fun");
		testDesk.createNewTicket("hello");
		
		
		testDesk.closeNextTicket();	// run the closeNextTicket method
		// if the next ticket was successfully removed, test passes
		if(testDesk.array[0].toString().equals("hello")) 
			return true;
		return false;
	}
	/**
	 * Tests the checkNextTicket method from the HelpDesk class
	 * 
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testCheckNextTicket() {
		HelpDesk testDesk = new HelpDesk(10);	// test help desk

		testDesk.createNewTicket("happy");	// test tickets
		testDesk.createNewTicket("sad");
		testDesk.createNewTicket("fun");
		testDesk.createNewTicket("cool");
		// if the next ticket is correct, test passes
		if(testDesk.checkNextTicket().equals("happy"))
			return true;
		return false;
	}
	/**
	 * Tests that the checkNextTicket method throws an
	 * IllegalStateException if called on an empty list
	 *
	 * @return	true if test passes, false if it doesn't
	 */
	public static boolean testCheckNextTicketEmptyList() {
		HelpDesk testDesk = new HelpDesk(4); // Create help desk
		try {
			testDesk.checkNextTicket();
		// Check to see that the correct exception is thrown
		} catch (IllegalStateException e) { 
			return true;
		} catch (Exception e) { // If it catches the wrong exception, return false.
			return false;
		}
		return false;
	}
}
