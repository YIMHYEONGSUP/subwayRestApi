package iwillbe.exam.domain.line.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import iwillbe.exam.domain.line.dto.LineRegisterRequestDTO;
import iwillbe.exam.domain.line.dto.LineRegisterResponseDTO;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.service.LineService;
import iwillbe.exam.domain.station.dto.StationRegisterRequestDTO;
import iwillbe.exam.domain.station.dto.StationResponseDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/line")
@RequiredArgsConstructor
@JsonAutoDetect
public class LineController {

    @Autowired
    LineService lineService;

    @Autowired
    StationService stationService;
    @PostMapping
    public ResponseEntity<LineRegisterResponseDTO> registerLine(@RequestBody LineRegisterRequestDTO requestDTO) {

        Line line = Line.builder()
                .start(requestDTO.getStart())
                .time(requestDTO.getTime())
                .end(requestDTO.getEnd()).build();

        URI registerLineURI = URI.create(String.format("/line/%d", line.getId()));
        return ResponseEntity.created(registerLineURI).body(lineService.registerLine(line));
    }
}
