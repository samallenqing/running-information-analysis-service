package FirstHomeWork.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "Running_Analysis")
public class RunningInformation {

    @Id
    @GeneratedValue
    private long id;

    private String runningId;

    public enum healthWarningLevel{
        HIGH, NORMAL, LOW;
    }

    private double latitude;
    private double longitude;
    private String runningDistance;
    private String totalRunningTime;
    public int heartRate;
    private Date timestamp = new Date();
    private healthWarningLevel healthWarningLevel;

   @Embedded
    private UserInfo userInfo;

    public RunningInformation() {
        this.heartRate = setHealthWarningLevel();
        if (heartRate >= 60 && heartRate <= 75) this.healthWarningLevel = healthWarningLevel.LOW;
        if (heartRate > 75 && heartRate <= 120) this.healthWarningLevel = healthWarningLevel.NORMAL;
        if (heartRate > 120) this.healthWarningLevel = healthWarningLevel.HIGH;
    }

    private int setHealthWarningLevel() {
        Random random = new Random();
        return random.nextInt(141) + 60;
    }

}
