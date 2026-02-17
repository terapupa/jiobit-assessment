package com.jiobit.assessment.controller;

import com.jiobit.assessment.domain.JiobitEntity;
import com.jiobit.assessment.domain.JiobitEntityDto;
import com.jiobit.assessment.exception.AppException;
import com.jiobit.assessment.repository.JiobitRepository;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JiobitController {

  private final JiobitRepository repository;

  @Autowired
  public JiobitController(JiobitRepository repository) {
    this.repository = repository;
  }

  /**
   * Add new geolocation data.
   *
   * @param guid - the mobile app id.
   * @param dto - the mobile app data.
   * @return - ResponseEntity<JiobitEntity>.
   */
  @PostMapping(path = "/jiobit/add")
  @ResponseBody
  public ResponseEntity<JiobitEntity> add(@RequestParam String guid, @RequestBody JiobitEntityDto dto) {
    String localGuid = Optional.ofNullable(guid).filter(s -> !s.isEmpty())
            .orElseThrow(() -> new AppException("The guid is required"));
    JiobitEntity entity = new JiobitEntity(localGuid, Instant.now().toEpochMilli(), dto.getLatitude(),
        dto.getLongitude(), dto.getAccuracy());
    return new ResponseEntity<>(repository.save(entity), HttpStatus.OK);
  }

  /**
   * Retrieve geolocation data by the mobile app id.
   *
   * @param guid - the mobile app id.
   * @return - ResponseEntity<List<JiobitEntity>>.
   */
  @GetMapping("/jiobit/{guid}")
  @ResponseBody
  public ResponseEntity<List<JiobitEntity>> getByGuid(@PathVariable String guid) {
    String localGuid = Optional.ofNullable(guid).filter(s -> !s.isEmpty())
            .orElseThrow(() -> new AppException("The guid is required"));
    return new ResponseEntity<>(repository.findByGuid(localGuid), HttpStatus.OK);
  }
}
