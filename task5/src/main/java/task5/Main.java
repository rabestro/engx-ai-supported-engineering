package task5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

  public static void main(String[] args) throws ParseException {
    List<Slot> slots = new ArrayList<>();
    slots.add(new Slot(parseDate("2023-09-15T10:00:00"), false));
    slots.add(new Slot(parseDate("2023-09-15T11:00:00"), false));
    slots.add(new Slot(parseDate("2023-09-16T10:00:00"), false));
    slots.add(new Slot(parseDate("2023-09-16T11:00:00"), false));

    Date startDate = parseDate("2023-09-15T10:00:00");
    Date endDate = parseDate("2023-09-16T12:00:00");
    Slot reservedSlot = reserveEarliestSlot(startDate, endDate, slots);

    if (reservedSlot != null) {
      System.out.println("Slot reserved: " + reservedSlot.date);
    } else {
      System.out.println("No available slots within specified date range");
    }
  }

  static Slot reserveEarliestSlot(Date startDate, Date endDate, List<Slot> slots) {
    Slot earliestSlot = null;

    for (Slot slot : slots) {
      if (slot.date.getTime() >= startDate.getTime() && slot.date.getTime() <= endDate.getTime()
          && !slot.reserved) {
        if (earliestSlot == null || slot.date.getTime() < earliestSlot.date.getTime()) {
          earliestSlot = slot;
        }
      }
    }

    if (earliestSlot != null) {
      earliestSlot.reserved = true;
    }

    return earliestSlot;
  }

  static Date parseDate(String dateString) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    return dateFormat.parse(dateString);
  }

  static class Slot {

    Date date;
    boolean reserved;

    Slot(Date date, boolean reserved) {
      this.date = date;
      this.reserved = reserved;
    }
  }
}