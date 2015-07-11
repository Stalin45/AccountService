package bl.com.accountservice.service.Impl;

import bl.com.accountservice.service.UserService;
import domain.com.accountservice.dao.UserDAO;
import domain.com.accountservice.dao.impl.UserDAOImpl;
import domain.com.accountservice.dto.UserInfoDTO;
import domain.com.accountservice.model.User;

/**
 * @Author Илья
 * @Created 08.07.2015.
 */
public class UserServiceImpl implements UserService {

    public UserInfoDTO getUser(Integer id) throws Exception {
        UserDAO dao = new UserDAOImpl();
        User user;
        try {
            user = dao.getById((long) id);
        } catch (Exception e) {
            //LOG
            throw e;
        }

        UserInfoDTO dto = new UserInfoDTO(user.getFirstName(), user.getLastName());
        return dto;
    }
}
