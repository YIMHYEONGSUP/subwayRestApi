package iwillbe.exam.domain.station;

import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.line.repository.LineRepository;
import iwillbe.exam.domain.station.entity.persist.Station;
import iwillbe.exam.domain.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class IntegrationTest {

    @Autowired
    EntityManager em;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    LineRepository lineRepository;


    @Test
    @DisplayName("지하철 , 라인 생성 테스트")
    public void registerTest() {

        Station station = Station.builder().stationName("역삼역").build();
        Line line = Line.builder().start(station).end("강남").build();

        Station savedStation = stationRepository.save(station);
        Line savedLine = lineRepository.save(line);

        System.out.println("savedStation = " + savedStation.getStationName());
        System.out.println("savedLine.getStart() = " + savedLine.getStart().getStationName() );
        System.out.println("savedLine.getEnd() = " + savedLine.getEnd());

    }

}
