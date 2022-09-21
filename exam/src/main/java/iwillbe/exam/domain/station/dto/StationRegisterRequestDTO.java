package iwillbe.exam.domain.station.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@JsonTypeName("station")
@NoArgsConstructor
public class StationRegisterRequestDTO {

    @JsonProperty("station_name")
    private String stationName;

    @Builder
    public StationRegisterRequestDTO(final String stationName) {
        this.stationName = stationName;
    }

    public static StationRegisterRequestDTO from(final Station station) {
        return new StationRegisterRequestDTO(station.getStationName());
    }

    public Station toEntity() {
        return Station.builder()
                .stationName(stationName)
                .build();
    }
}
