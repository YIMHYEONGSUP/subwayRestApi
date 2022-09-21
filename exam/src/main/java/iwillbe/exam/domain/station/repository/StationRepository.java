package iwillbe.exam.domain.station.repository;

import iwillbe.exam.domain.station.entity.persist.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {

    Station findByStationName(final String stationName);
}
