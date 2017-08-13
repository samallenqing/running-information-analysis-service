package FirstHomeWork.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class UserInfo {
    private String username;
    private String address;

    public UserInfo() { }
}
