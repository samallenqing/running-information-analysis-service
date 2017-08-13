package FirstHomeWork.service;

import FirstHomeWork.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {
     void deleteByRunningId(String runningId);
     Page<RunningInformation> findByHealthWarningLevel(Pageable pageable);
     List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);
}
