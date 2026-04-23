package module6;

//Import JUnit assertion methods
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
//Import JUnit Test annotation
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;


//Test class for the Appointment class
public class AppointmentTest {
	private Calendar calendar;
@BeforeEach
  void setUp(){
    calendar = Calendar.getInstance();
  }


//Test that a Appointment object is created successfully with valid data
@Test
void testAppointmentCreationSuccess() {
 
   calendar.add(Calendar.DAY_OF_MONTH, 5);   // add 5 days 
	 // Create a valid Appointment object
	 Appointment appointment = new Appointment(
       "1234567890",
       calendar.getTime(),
       "Doctor's Appointment"
	 );

   // Verify the object was created
   assertNotNull(appointment);

   // Verify all fields were set correctly
   assertEquals("1234567890", appointment.getAppointmentId());
   assertEquals(calendar.getTime(), appointment.getDate());
   assertEquals("Doctor's Appointment", appointment.getDescription());
}

//Test that an exception is thrown when appointment ID is too long
@Test
void testAppointmentIdTooLong() {
	calendar.add(Calendar.DAY_OF_MONTH, 5);   // add 5 days 
	assertThrows(IllegalArgumentException.class, () -> {
   	new Appointment(
           "12345678901", // Invalid: more than 10 characters
           calendar.getTime(),
           "Doctor's Appointment"
   	);
	});
}
//Test that an exception is thrown when AppointmentID is null
@Test
void testappointmentIDNull() {
	calendar.add(Calendar.DAY_OF_MONTH, 5);   // add 5 days 
	assertThrows(IllegalArgumentException.class, () -> {
		new Appointment(
		  	null, // Invalid: AppointmentID is null
      	calendar.getTime(),
   		"Doctor's Appointment"
		);
	});
}

//Test that an exception is thrown when date is null
@Test
void testDateNull() {
	calendar.add(Calendar.DAY_OF_MONTH, 5);   // add 5 days  
	assertThrows(IllegalArgumentException.class, () -> {
		new Appointment(
           "1234567890",
           null, // Invalid:  name is null
           "Doctor's Appointment"
   	);
	});
}

//Test that an exception is thrown when date before today
@Test
void testDateInPast() {
  calendar.add(Calendar.DAY_OF_MONTH, -2);   // minus 2 days  
	assertThrows(IllegalArgumentException.class, () -> {
   	new Appointment(
           "123456789",
           calendar.getTime(), // Invalid: date before today
           "Doctor's Appointment"
 		);
	});
}

//Test that an exception is thrown when Description is too long
@Test
void testDescriptionTooLong() {
  calendar.add(Calendar.DAY_OF_MONTH, 2);   // add 2 days  
	assertThrows(IllegalArgumentException.class, () -> {
   	new Appointment(
           "1234567890",
           calendar.getTime(), 
           "This Description is too long to be accepted by the system" // Invalid > 50 characters
   	);
	});
}
//Test that an exception is thrown when Description is null
@Test
void testDescriptionNull() {
  calendar.add(Calendar.DAY_OF_MONTH, 2);   // add 2 days  
	assertThrows(IllegalArgumentException.class, () -> {
		new Appointment(
          "1234567890",
          calendar.getTime(), 
          null // Invalid:  Description is null
		);
	});
}
//Test to set Data to be up to date
@Test
void testSetDateSuccess() {
    calendar.add(Calendar.DAY_OF_MONTH, 5);
    Appointment appointment = new Appointment(
        "123",
        calendar.getTime(),
        "Test"
    );

    calendar.add(Calendar.DAY_OF_MONTH, 2); // new future date
    Date newDate = calendar.getTime();

    appointment.setDate(newDate);

    assertEquals(newDate, appointment.getDate());
}
//Test to set Date if it were to be past due date
@Test
void testSetDatePast() {
    calendar.add(Calendar.DAY_OF_MONTH, 5);
    Appointment appointment = new Appointment(
        "123",
        calendar.getTime(),
        "Test"
    );

    calendar.add(Calendar.DAY_OF_MONTH, -10); // past date

    assertThrows(IllegalArgumentException.class, () -> {
        appointment.setDate(calendar.getTime());
    });
}
}
