package com.brande.linkedin.spring.repository;

import com.brande.linkedin.spring.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

}
