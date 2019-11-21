package ru.skholstinin.testtask.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skholstinin.testtask.dao.UserDao;
import ru.skholstinin.testtask.dto.RegistrationPageDTO;
import ru.skholstinin.testtask.pojo.User;
import ru.skholstinin.testtask.security.model.Roles;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean addUser(RegistrationPageDTO userPageDTO) {
        userPageDTO.setPassword(passwordEncoder.encode(userPageDTO.getPassword()));
        userPageDTO.setPasswordDouble(userPageDTO.getPassword());
        User user = convertUserDtpToUserPojo(userPageDTO);
        return false;
    }

    @Override
    public RegistrationPageDTO createRegistrationPageInfo(String name, String surname, String login, String password, String passwordDouble) {
        return null;
    }

    @Override
    public boolean isNameEmpty(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean isSurNameEmpty(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean isLoginEmpty(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean isPasswordEmpty(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean isPasswordDoubleEmpty(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean isPasswordEquals(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean isLoginUnique(RegistrationPageDTO registrationInfo) {
        return false;
    }

    @Override
    public boolean validateLength(String val, int len) {
        return false;
    }

    private User convertUserDtpToUserPojo(RegistrationPageDTO pageDTO) {
        User user = new User();
        user.setRole(Roles.ROLE_USER);
        user.setName(pageDTO.getName());
        user.setSurname(pageDTO.getSurname());
        user.setLogin(pageDTO.getLogin());
        user.setPassword(pageDTO.getPassword());
        user.setEnabled(true);
        return user;
    }
}
