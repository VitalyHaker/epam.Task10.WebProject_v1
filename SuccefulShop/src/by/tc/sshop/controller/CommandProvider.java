package by.tc.sshop.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.sshop.command.Command;
import by.tc.sshop.command.impl.*;

class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
    private static final CommandProvider instance = new CommandProvider();

    private CommandProvider() {
        commands.put(CommandName.LOG_IN, new LoginCommand());
        commands.put(CommandName.REGISTER, new RegisterCommand());
        commands.put(CommandName.LOG_OUT, new LogoutCommand());
        commands.put(CommandName.USER_PAGE, new UserPageCommand());
        commands.put(CommandName.VIEW_USER, new ViewUserCommand());
        commands.put(CommandName.VIEW_USERS, new ViewUsersCommand());        
        commands.put(CommandName.ADD_BIKE, new AddBikeCommand());
        commands.put(CommandName.UPDATE_BIKE, new UpdateBikeCommand());
        commands.put(CommandName.VIEW_BIKES, new ViewBikesCommand());
        commands.put(CommandName.BIKE_BY_ID, new ViewBikeByIdCommand());
        commands.put(CommandName.BIKES_BY_BRAND, new ViewBikesByBrandCommand());
        commands.put(CommandName.BIKES_BY_WHEELDIAM, new ViewBikesByWheeldiamCommand());        
        commands.put(CommandName.ADD_COMMENT, new AddBikeCommentCommand());

    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String commandName){
        String cmd = commandName.replace("-","_").toUpperCase();
        CommandName name = CommandName.valueOf(cmd);
        Command command;
        command = commands.get(name);
        return command;
    }
}

