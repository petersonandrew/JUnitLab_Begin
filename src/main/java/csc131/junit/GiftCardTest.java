package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest {
	@Test
	public void getIssuingStore() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	
 	@Test
	public void getBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct_RemainingBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct()", "Remaining Balance:  50.75", card.deduct(49.25));
	}
	
	@Test
	public void deduct_Negative() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct()", "Invalid Transaction", card.deduct(-1));
	}
	
	@Test
	public void deduct_Due() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct()", "Amount Due:   1.00", card.deduct(101));
	}
	
	@Test
	public void negative_Balance() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1, -100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1, 100);});
	}
	
	@Test
	public void constructor_IncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000, 100);});
	}
}