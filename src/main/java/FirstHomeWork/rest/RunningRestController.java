package FirstHomeWork.rest;

import FirstHomeWork.domain.RunningInformation;
import FirstHomeWork.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningRestController {

    @Autowired
    private RunningInformationService runningInformationService;

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> informations) {
        this.runningInformationService.saveRunningInformation(informations);
    }

    @RequestMapping(value = "/delete/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId) {
        this.runningInformationService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public Page<RunningInformation> findByHealthWarningLevel(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "2") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "healthWarningLevel") String lable,
            @RequestParam(name = "desc", required = false, defaultValue = "true") boolean desc) {
        Sort sort = new Sort(desc ? Sort.Direction.ASC : Sort.Direction.DESC, lable);
        return this.runningInformationService.findByHealthWarningLevel(new PageRequest(page, size, sort));
    }
}
