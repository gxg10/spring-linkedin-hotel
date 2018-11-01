package com.brande.linkedin.spring;

import com.brande.linkedin.spring.entity.RoomEntity;
import com.brande.linkedin.spring.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    RoomRepository roomRepository;


    @Override
    public void run(String... args) throws Exception {
        roomRepository.save(new RoomEntity(405, "200"));
        roomRepository.save(new RoomEntity(406, "250"));
        roomRepository.save(new RoomEntity(407, "280"));

        Iterable<RoomEntity> itr = roomRepository.findAll();

        for(RoomEntity room: itr) {
            System.out.println(room.getRoomNumber());
        }

    }
}
