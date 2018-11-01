package com.brande.linkedin.spring.converter;

import com.brande.linkedin.spring.entity.RoomEntity;
import com.brande.linkedin.spring.model.response.Links;
import com.brande.linkedin.spring.model.response.ReservationResponse;
import com.brande.linkedin.spring.model.response.Self;
import com.brande.linkedin.spring.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;


public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse>{

    @Override
    public ReservationResponse convert(RoomEntity source) {
        // TODO Auto-generated method stub

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setRoomNumber(source.getRoomNumber());
        reservationResponse.setPrice( Integer.valueOf(source.getPrice()) );

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);

        reservationResponse.setLinks(links);

        return reservationResponse;
    }



}