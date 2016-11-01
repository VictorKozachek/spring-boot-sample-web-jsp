package ru.schoolarlife.logic.bl.security.interfaces;

/**
 * Created by victor on 01.11.16.
 */
public interface SecurityService {

    public String findLoggedInUsername();

    public void autologin(String username, String password);
}
