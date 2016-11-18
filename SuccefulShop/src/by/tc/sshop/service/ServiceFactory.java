package by.tc.sshop.service;

import by.tc.sshop.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory INST = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return INST;
    }

    private RegisterService registerService = new RegisterServiceImpl();
    private UserService userService = new UserServiceImpl();
    private LoginService loginService = new LoginServiceImpl();

    private BikeService BikeService = new BikeServiceImpl();
    private AdminService adminService = new AdminServiceImpl();



    public LoginService getLoginService() {
        return loginService;
    }

    public RegisterService getRegisterService() {
        return registerService;
    }
    
    public UserService getUserService() {
    return userService;
    }

    public BikeService getBikeService() {
        return BikeService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

}
