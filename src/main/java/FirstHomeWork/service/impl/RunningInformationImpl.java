package FirstHomeWork.service.impl;

import FirstHomeWork.domain.RunningInformation;
import FirstHomeWork.domain.RunningInformationRepository;
import FirstHomeWork.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationImpl implements RunningInformationService {

    @Autowired
    RunningInformationRepository runningInformationRepository;

    @Override
    public void deleteByRunningId(String runningId) {
        this.runningInformationRepository.deleteByRunningId(runningId);

    }

    @Override
    public Page<RunningInformation> findByHealthWarningLevel(Pageable pageable) {
        return runningInformationRepository.findAll(pageable);
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return runningInformationRepository.save(runningInformations);
    }
}
