package com.dreammovie.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllActiveRooms() {
        // Only return records that are not soft deleted (deletedAt is null)
        return roomRepository.findByDeletedAtIsNull();
    }

    public void softDeleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Set deletedAt to the current time to mark it as deleted
        room.setDeletedAt(LocalDateTime.now());
        roomRepository.save(room);
    }

    public Optional<Room> getRoomById (Long id){
        return roomRepository.findById(id);
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public Room updateRoom (Long id, Room updateRoom){
        Optional<Room> roomOptional = roomRepository.findById(id);
        if(roomOptional.isPresent()){
            Room existingRoom = roomOptional.get();
            existingRoom.setName(updateRoom.getName());
            existingRoom.setCapacity(updateRoom.getCapacity());
            existingRoom.setCinema(updateRoom.getCinema());

            return roomRepository.save(existingRoom);
        }
        return null;
    }

    public void deleteRoom (Long id){
        roomRepository.deleteById(id);
    }
}
