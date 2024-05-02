package repository;

import domeniu.Boss;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BossRepository {

    private JDBCUtils dbUtils;

    public BossRepository(Properties props) {

        dbUtils = new JDBCUtils(props);
    }
    private List<Boss> bosses;

    public BossRepository() {
        this.bosses = new ArrayList<>();
    }

    public void addBoss(Boss Boss) {

        Connection con = dbUtils.getConnection();

        bosses.add(Boss);
    }

    public Boss findBossById(int id) {

        Connection con = dbUtils.getConnection();

        for (Boss Boss : bosses) {
            if (Boss.getId() == id) {
                return Boss;
            }
        }
        return null;
    }

    public Boss findBoss(String email, String password) {

        Connection con = dbUtils.getConnection();

        for (Boss boss : bosses) {
            if (boss.getEmail().equals(email) && boss.getPassword().equals(password)) {
                return boss;
            }
        }
        return null;
    }

    public void updateBoss(Boss Boss) {

        Connection con = dbUtils.getConnection();

        for (int i = 0; i < bosses.size(); i++) {
            if (bosses.get(i).getId() == Boss.getId()) {
                bosses.set(i, Boss);
                return;
            }
        }
    }

    public void deleteBoss(Boss Boss) {

        Connection con = dbUtils.getConnection();

        bosses.remove(Boss);
    }

    public List<Boss> getBosses() {
        return bosses;
    }
}
