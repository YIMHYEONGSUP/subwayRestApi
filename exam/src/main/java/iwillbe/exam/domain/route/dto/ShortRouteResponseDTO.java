package iwillbe.exam.domain.route.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ShortRouteResponseDTO {

    private Long shortestTime;

    private List<String> shortestRoute;

    @Builder
    public ShortRouteResponseDTO (final Long shortestTime , final List<String> shortestRoute) {
        this.shortestTime = shortestTime;
        this.shortestRoute = shortestRoute;
    }

}
