package com.synchrony.project.reservation.integrationTests;

import com.synchrony.project.reservation.entity.RoomDetails;
import com.synchrony.project.reservation.model.RoomDetailsDTO;
import com.synchrony.project.reservation.service.bookingservices.RoomDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
public class RoomControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RoomDetailsService roomDetailsService;


    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCreateRooms() throws Exception {
        RoomDetailsDTO roomDetailsDTO1 = new RoomDetailsDTO(1L, 1,  100.00, "SINGLE");
        RoomDetailsDTO roomDetailsDTO2 = new RoomDetailsDTO(2L, 2, 200.00, "DOUBLE");
        List<RoomDetailsDTO> roomDetailsDTOList = List.of(roomDetailsDTO1, roomDetailsDTO2);

        RoomDetails roomDetails1 = new RoomDetails(1L, 1,  100.00, "SINGLE");
        RoomDetails roomDetails2 = new RoomDetails(2L, 2, 200.00, "DOUBLE");

        when(roomDetailsService.createRooms(anyList())).thenReturn(List.of(roomDetails1, roomDetails2));

        mockMvc.perform(post("/createRooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[{\"roomId\":1,\"roomName\":\"Room1\",\"roomType\":\"Type1\"}, {\"roomId\":2,\"roomName\":\"Room2\",\"roomType\":\"Type2\"}]"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Check if cache is updated
        assert cacheManager.getCache("roomDetails").get(1L) != null;
        assert cacheManager.getCache("roomDetails").get(2L) != null;

        // Verify service method interaction
        verify(roomDetailsService, times(1)).createRooms(anyList());
    }

    @Test
    public void testGetAllRooms() throws Exception {
        RoomDetails roomDetails1 = new RoomDetails(1L, 1,  100.00, "SINGLE");
        RoomDetails roomDetails2 = new RoomDetails(2L, 2, 200.00, "DOUBLE");
        List<RoomDetails> roomDetailsList = List.of(roomDetails1, roomDetails2);

        when(roomDetailsService.getAllRooms()).thenReturn(roomDetailsList);

        mockMvc.perform(get("/getRooms"))
                .andExpect(status().isOk());

        // Verify if cache is populated
        assert cacheManager.getCache("roomDetailsList").get("roomDetailsList") != null;

        verify(roomDetailsService, times(1)).getAllRooms();
    }
}
