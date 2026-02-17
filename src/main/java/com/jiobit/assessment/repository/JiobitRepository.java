package com.jiobit.assessment.repository;

import com.jiobit.assessment.domain.JiobitEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JiobitRepository extends CrudRepository<JiobitEntity, Long> {

  /**
   * Retrieve geolocation data by the mobile app id.
   *
   * @param guid - the mobile app id.
   * @return - List of mobile data entities.
   */
  List<JiobitEntity> findByGuid(String guid);
}
