package com.enigma.process;

import com.enigma.constanta.CommandConstant;
import com.enigma.dao.PierDao;
import com.enigma.dao.PierDaoMapImplementations;
import com.enigma.model.Boat;

import java.util.List;

public class CommandsProcessorImplementation implements CommandsProcessor {
    private static final String SPLIT_TARGET=" ";
    public CommandsProcessorImplementation() { }
    private PierDao pierDao = new PierDaoMapImplementations();
    @Override
    public void executeCommand(List<String> stringList) {
        for (String stringCommand : stringList) {
            commandSwitcher(stringCommand);
        }
    }

    private void commandSwitcher(String stringCommand) {
        String[] data = stringCommand.split(SPLIT_TARGET);
        switch (data[0]) {
            case CommandConstant.CREATE:
                pierDao.setCapacity(Integer.parseInt(data[1]));
                System.out.println(pierDao.create());
                break;
            case CommandConstant.DOCK:
                System.out.println(pierDao.dock(new Boat(data[1])));
                break;
            case CommandConstant.LEAVE:
                System.out.println(pierDao.leave(Integer.parseInt(data[1])));
                break;
            case CommandConstant.RESERVE:
                System.out.println(pierDao.reserve(new Boat(data[1])));
                break;
            case CommandConstant.STATUS:
                System.out.println(pierDao.status());
        }
    }
}
