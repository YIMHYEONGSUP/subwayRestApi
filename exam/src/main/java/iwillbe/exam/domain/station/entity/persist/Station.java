package iwillbe.exam.domain.station.entity.persist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.dto.StationRegisterRequestDTO;
import iwillbe.exam.domain.station.dto.StationResponseDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Station {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Long id;

    @Column(name = "station_name")
    private String stationName;


    @Builder
    public Station(final String stationName) {
        this.stationName = stationName;
    }

    public StationRegisterRequestDTO toRequestDTO() {
        return StationRegisterRequestDTO.builder()
                .stationName(stationName)
                .build();
    }

    public static Station create(final StationResponseDTO responseDTO) {
        return Station.builder()
                .stationName(responseDTO.getStationName())
                .build();
    }

}
