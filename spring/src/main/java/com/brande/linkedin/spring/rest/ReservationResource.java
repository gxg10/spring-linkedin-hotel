package com.brande.linkedin.spring.rest;

import com.brande.linkedin.spring.converter.RoomEntityToReservationResponseConverter;
import com.brande.linkedin.spring.entity.RoomEntity;
import com.brande.linkedin.spring.model.request.ReservationRequest;
import com.brande.linkedin.spring.model.response.ReservationResponse;
import com.brande.linkedin.spring.repository.PageableRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableRoomRepository pageableRoomRepository;

    @RequestMapping(path= "", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservationResponse>  getAvailableRooms(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout, Pageable pageable) {

        Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);

        return roomEntityList.map(new RoomEntityToReservationResponseConverter());
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {
        return new ResponseEntity<>(new ReservationResponse(),
                HttpStatus.CREATED);
    }
}
