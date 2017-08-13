package FirstHomeWork.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {
     Long deleteByRunningId(@Param("runningId") String runningId);
}
