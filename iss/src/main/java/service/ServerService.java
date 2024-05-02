package service;

import domeniu.Boss;
import repository.BossRepository;
import repository.EmployeeRepository;

import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class ServerService {
    private static ServerService instance;
    private final EmployeeRepository employeeRepository;
    private final BossRepository bossRepository;

    private ServerService() {
        this.employeeRepository = instantiateEmployeeRepository();
        this.bossRepository = instantiateBossRepository();
    }

    public static synchronized ServerService getInstance() {
        if (instance == null) {
            instance = new ServerService();
        }
        return instance;
    }

    private EmployeeRepository instantiateEmployeeRepository() {
        Properties props = loadProperties();
        return new EmployeeRepository(props);
    }

    private BossRepository instantiateBossRepository() {
        Properties props = loadProperties();
        return new BossRepository(props);
    }
    private Properties loadProperties() {
        Properties props = new Properties();
        try {
            props.load(new FileReader("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config " + e);
        }
        return props;
    }

    public EmployeeService getEmployeeService() {
        return new EmployeeService(employeeRepository);
    }

    public BossService getBossService() {
        return new BossService(bossRepository);
    }

}


