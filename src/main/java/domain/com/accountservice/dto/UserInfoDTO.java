package domain.com.accountservice.dto;

/**
 * @Author Илья
 * @Created 08.07.2015.
 */
public class UserInfoDTO {

    private String name;

    private String secondName;

    public UserInfoDTO() {
    }

    public UserInfoDTO(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
