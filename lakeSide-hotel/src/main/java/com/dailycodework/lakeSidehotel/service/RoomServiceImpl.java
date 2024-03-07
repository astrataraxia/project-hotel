package com.dailycodework.lakeSidehotel.service;

import com.dailycodework.lakeSidehotel.model.Room;
import com.dailycodework.lakeSidehotel.repository.RoomRepository;
import com.dailycodework.lakeSidehotel.response.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements IRoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomResponse addNewRoom(MultipartFile file,
                                   String roomType,
                                   BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        Room savedRoom = roomRepository.save(room);
        return new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
    }
}
