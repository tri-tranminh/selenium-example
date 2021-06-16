package utilities;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class DataHelper {

	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	
	public static DataHelper getData() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	
	public String getCompanyName() {
		return faker.company().name();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getCountry(){
		return faker.address().country();
	}

	public String getState(){
		return faker.address().state();
	}

	public String getCity(){
		return faker.address().city();
	}

	public String getPostalCode(){
		return faker.address().zipCode();
	}

	public String getPhoneNumber(){
		return faker.phoneNumber().phoneNumber();
	}

	public String getFaxNumber(){
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress1(){
		return faker.address().fullAddress();
	}

	public String getAddress2(){
		return faker.address().secondaryAddress();
	}

	public String getCreditCardNumber(){
		return faker.finance().creditCard(CreditCardType.VISA);
	}
}
