package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CollectionTypeService service;

  @Test
  public void testGetCollectionTypesCount() throws Exception {
      CollectionTypeCount count = new CollectionTypeCount(new String[]{"Type1", "Type2"}, 15L);
      Mockito.when(service.countByCollectionTypes("Type1, Type2")).thenReturn(count);

      mockMvc.perform(MockMvcRequestBuilders
              .get("/collections/count/{typesList}", "Type1, Type2"))
              .andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(15));
  }
}
