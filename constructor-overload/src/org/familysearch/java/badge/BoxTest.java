package org.familysearch.java.badge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

public class BoxTest {

  Box testBox;

  @org.junit.Before
  public void setUp() throws Exception {
  }

  @org.junit.After
  public void tearDown() throws Exception {
  }

  @org.junit.Test
  public void volume() {
  }

  @org.junit.Test
  public void getBoxNumber() {
  }

  @org.junit.Test
  public void getBoxLabel() {
  }

  @org.junit.Test
  public void dumpBox() {
    testBox = new Box(3,4,5);
    String boxStr = testBox.dumpBox();

    assertNotNull(boxStr);
    assertEquals("Default Box Number should be 0.",0, testBox.getBoxNumber());

    assertThat("Box Dump Header should contain 'Box Dump' text", boxStr, containsString("Box Dump"));
    assertThat(boxStr, containsString("Width: 3"));
    assertThat(boxStr, containsString("Height: 4"));
    assertThat(boxStr, containsString("Depth: 5"));
  }

  @org.junit.Test
  public void dumpBox_MockTest() throws ParseException {
    String string_date = "02-FEB-2020";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    Date testDate = sdf.parse(string_date);

    Calendar calendarMock = Mockito.mock(Calendar.class);
    when(calendarMock.getTimeInMillis()).thenReturn(testDate.getTime());

    Box testBox = new Box();
    testBox.shipBox(calendarMock);
    assertThat(testBox.dumpBox(), containsString("ShipDate: 02 Feb 2020"));
  }

  @org.junit.Test
  public void dumpBox1() {
  }
}