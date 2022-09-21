package iwillbe.exam.domain.line.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import iwillbe.exam.domain.line.entity.persist.Line;
import iwillbe.exam.domain.station.entity.persist.Station;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonTypeName("line")
@NoArgsConstructor
public class LineRegisterRequestDTO {

    @JsonProperty("line_start")
    private String start;

    @JsonProperty("line_time")
    private Long time;

    @JsonProperty("line_end")
    private String end;

    @Builder
    public LineRegisterRequestDTO(final String start, final Long time , final String end) {
        this.start = start;
        this.time = time;
        this.end = end;
    }

    public static LineRegisterRequestDTO from(final Line line) {
        return LineRegisterRequestDTO.builder()
                .time(line.getTime())
                .end(line.getEnd())
                .build();
    }

    public Line toEntity() {

        return Line.builder()
                .end(end)
                .build();
    }

}
