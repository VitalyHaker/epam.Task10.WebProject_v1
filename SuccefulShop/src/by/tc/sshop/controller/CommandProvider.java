package by.tc.sshop.controller;

import by.tc.sshop.command.Command;
import by.tc.sshop.command.impl.*;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
    private static final CommandProvider instance = new CommandProvider();


    private CommandProvider() {
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.REGISTER, new RegisterCommand());
        commands.put(CommandName.USER_PAGE, new UserPageCommand());
        commands.put(CommandName.LOG_OUT, new LogoutCommand());
        commands.put(CommandName.VIEW_BIKES, new ViewBikesCommand());
        commands.put(CommandName.ADD_BIKE, new AddBikeCommand());
        commands.put(CommandName.UPDATE_BIKE, new UpdateBikeCommand());
        //commands.put(CommandName.BIKE_BY_ID, new ShowBikeId());
        commands.put(CommandName.BIKES_BY_BRAND, new ViewBikesBrandCommand());
        commands.put(CommandName.BIKES_BY_WHEELDIAM, new ViewBikesWheeldiamCommand());
        commands.put(CommandName.ADD_COMMENT, new AddBikeCommentCommand());
        commands.put(CommandName.VIEW_USERS, new ViewUsersCommand());
        commands.put(CommandName.VIEW_USER, new ViewUserCommand());

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

