package iwillbe.exam.domain.station.service;

import iwillbe.exam.domain.station.dto.StationRegisterResponseDTO;
import iwillbe.exam.domain.station.dto.StationResponseDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface StationService {

    StationRegisterResponseDTO registerStation(Station station);

    StationResponseDTO findByStationName(String stationName);
}
