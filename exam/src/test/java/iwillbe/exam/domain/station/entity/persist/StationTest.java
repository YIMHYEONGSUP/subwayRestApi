package iwillbe.exam.domain.station.entity.persist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import iwillbe.exam.domain.station.controller.StationController;
import iwillbe.exam.domain.station.dto.StationRegisterRequestDTO;
import iwillbe.exam.domain.station.dto.StationRegisterResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class StationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    StationController stationController;


    @Test
    @DisplayName("지하철 등록")
    public void register() throws Exception {

        Station yeoksam = Station.builder().stationName("역삼역").build();
        StationRegisterRequestDTO request = StationRegisterRequestDTO.from(yeoksam);
        StationRegisterResponseDTO.from(yeoksam);

        String body = mapper.writeValueAsString(yeoksam);

        mockMvc.perform(post("/subway")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body))
                .andDo(print());
    }

}