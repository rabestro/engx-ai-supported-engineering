import java.util.ArrayList;  
import java.util.List;  
import java.util.Optional;  
  
public class HotelBookingService {  
    private List<Room> rooms = new ArrayList<>();  
  
    public HotelBookingService() {  
        rooms.add(new Room(101, "single", false));  
        rooms.add(new Room(102, "double", false));  
        rooms.add(new Room(103, "suite", false));  
        // ... add more rooms here  
    }  
  
    public Room bookRoom(String desiredType, String guestName) {  
        List<Room> availableRooms = new ArrayList<>();  
        for (Room room : rooms) {  
            if (room.getType().equals(desiredType) && !room.isReserved()) {  
                availableRooms.add(room);  
            }  
        }  
  
        Room roomToBook = availableRooms.get(0);  
        roomToBook.setReserved(true);  
        roomToBook.setGuestName(guestName);  
        return roomToBook;  
    }  
  
    public Room cancelBooking(int roomNumber) {  
        Optional<Room> roomToCancel = rooms.stream()  
                .filter(room -> room.getRoomNumber() == roomNumber)  
                .findFirst();  
  
        if (roomToCancel.isPresent()) {  
            Room canceledRoom = roomToCancel.get();  
            canceledRoom.setReserved(false);  
            canceledRoom.setGuestName(null);  
            return canceledRoom;  
        } else {  
            return null; // Room not found
        }  
    }  
  
    public List<Room> listAvailableRooms() {  
        List<Room> availableRooms = new ArrayList<>();  
        for (Room room : rooms) {  
            if (!room.isReserved()) {  
                availableRooms.add(room);  
            }  
        }  
        return availableRooms;  
    }  
  
    public Room getRoomDetails(int roomNumber) {  
        Optional<Room> roomDetails = rooms.stream()  
                .filter(room -> room.getRoomNumber() == roomNumber)  
                .findFirst();  
        return roomDetails.orElse(null);  
    }  
  
    public List<String> listGuests() {  
        List<String> guests = new ArrayList<>();  
        for (Room room : rooms) {  
            if (room.isReserved() && room.getGuestName() != null) {  
                guests.add(room.getGuestName());  
            }  
        }  
        return guests;  
    }  
  
    public boolean changeRoomType(int roomNumber, String newType) {  
        Optional<Room> roomToChange = rooms.stream()  
                .filter(room -> room.getRoomNumber() == roomNumber)  
                .findFirst();  
  
        if (roomToChange.isPresent()) {  
            Room changedRoom = roomToChange.get();  
            changedRoom.setType(newType);  
            return true;  
        } else {  
            return false; // Room not found
        }  
    }  
  
    public int getTotalRoomsByType(String type) {  
        long count = rooms.stream()  
                .filter(room -> room.getType().equals(type))  
                .count();  
        return (int) count;  
    }  
  
    public int getReservedRoomsByType(String type) {  
        long count = rooms.stream()  
                .filter(room -> room.getType().equals(type) && room.isReserved())  
                .count();  
        return (int) count;  
    }  
  
    // ... potentially more methods related to the booking system  
  
    private static class Room {  
        private int roomNumber;  
        private String type;  
        private boolean reserved;  
        private String guestName;  
  
        public Room(int roomNumber, String type, boolean reserved) {  
            this.roomNumber = roomNumber;  
            this.type = type;  
            this.reserved = reserved;  
        }  
  
        public int getRoomNumber() {  
            return roomNumber;  
        }  
  
        public String getType() {  
            return type;  
        }  
  
        public void setType(String type) {  
            this.type = type;  
        }  
  
        public boolean isReserved() {  
            return reserved;  
        }  
  
        public void setReserved(boolean reserved) {  
            this.reserved = reserved;  
        }  
  
        public String getGuestName() {  
            return guestName;  
        }  
  
        public void setGuestName(String guestName) {  
            this.guestName = guestName;  
        }  
    }  

}