package com.dailycodework.lakeSidehotel.service;

import com.dailycodework.lakeSidehotel.response.RoomResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRoomService {
    RoomResponse addNewRoom(MultipartFile photo,
                            String roomType,
                            BigDecimal roomPrice) throws IOException, SQLException;
}
