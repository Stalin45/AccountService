package bl.com.accountservice.service;

import domain.com.accountservice.dto.UserInfoDTO;

/**
 * @Author Илья
 * @Created 08.07.2015.
 */
public interface UserService {

    UserInfoDTO getUser(Integer id) throws Exception;
}
