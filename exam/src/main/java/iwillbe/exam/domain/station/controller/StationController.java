package iwillbe.exam.domain.station.controller;

import io.swagger.annotations.Api;
import iwillbe.exam.domain.station.dto.StationRegisterRequestDTO;
import iwillbe.exam.domain.station.dto.StationRegisterResponseDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.service.StationService;
import iwillbe.exam.domain.station.service.StationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Api("지하철 역 등록 API")
@Slf4j
@RestController
@RequestMapping("/subway")
@RequiredArgsConstructor
public class StationController {

    @Autowired
    StationService stationService;

    @PostMapping
    public ResponseEntity<StationRegisterResponseDTO> registerStation(@RequestBody StationRegisterRequestDTO requestDTO) {

        log.info("stationName = {} " , requestDTO.getStationName());

        Station station = requestDTO.toEntity();

        URI registerStationURI = URI.create(String.format("/subway/%d", station.getId()));
        return ResponseEntity.created(registerStationURI).body(stationService.registerStation(station));
    }

}
