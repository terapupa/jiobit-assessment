package com.jiobit.assessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.jiobit.assessment.controller.JiobitController;
import com.jiobit.assessment.domain.JiobitEntity;
import com.jiobit.assessment.domain.JiobitEntityDto;
import com.jiobit.assessment.repository.JiobitRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JiobitControllerTest {
  @Mock
  JiobitRepository jiobitRepository;

  JiobitController controller;

  @BeforeEach
  void before() {
    controller = new JiobitController(jiobitRepository);
  }

  @Test
  void addTest() {
    String guid = "test";
    when(jiobitRepository.save(any())).thenReturn(new JiobitEntity(guid,1,1,1,1));
    JiobitEntity entity = controller.add(guid, new JiobitEntityDto(1,1,1)).getBody();
    assertNotNull(entity);
  }

  @Test
  void getByGuidTest() {
    String guid = "test";
    when(jiobitRepository.findByGuid(any())).thenReturn(List.of(new JiobitEntity(guid,1,1,1,1)));
    List<JiobitEntity> entity = controller.getByGuid(guid).getBody();
    assertEquals(entity.size(), 1);
  }

}
