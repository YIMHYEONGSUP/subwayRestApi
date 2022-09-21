package iwillbe.exam.domain.route.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShortRouteRequestDTO {

    @JsonProperty("line_start")
    private String start;

    @JsonProperty("line_end")
    private String end;

    @Builder
    public ShortRouteRequestDTO(final String start, final String end) {
        this.start = start;
        this.end = end;
    }



}
