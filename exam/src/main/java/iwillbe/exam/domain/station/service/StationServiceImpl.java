package iwillbe.exam.domain.station.service;

import iwillbe.exam.domain.station.dto.StationRegisterResponseDTO;
import iwillbe.exam.domain.station.dto.StationResponseDTO;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class StationServiceImpl implements StationService{

    @Autowired
    private final StationRepository stationRepository;

    @Override
    public StationRegisterResponseDTO registerStation(Station station) {
        return StationRegisterResponseDTO.from(stationRepository.save(station));
    }

    @Override
    public StationResponseDTO findByStationName(String stationName) {
        Station findStationName = stationRepository.findByStationName(stationName);
        return StationResponseDTO.create(findStationName);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
