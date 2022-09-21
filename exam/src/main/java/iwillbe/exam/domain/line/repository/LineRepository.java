package iwillbe.exam.domain.line.repository;

import iwillbe.exam.domain.line.entity.persist.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line , Long> {
}
