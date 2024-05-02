package repository;

import domeniu.Boss;
import domeniu.Employee;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        try(PreparedStatement preSmt = con.prepareStatement("insert into boss " +
                "(id, email, name) values (?, ?, ?)")) {
            preSmt.setInt(1, Boss.getId());
            preSmt.setString(2, Boss.getEmail());
            preSmt.setString(3, Boss.getName());

            int result = preSmt.executeUpdate();

        }
        catch (SQLException ex) {
            System.err.println("Error db" + ex);
        }

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

        Boss boss = null;

        try (PreparedStatement preSmt = con.prepareStatement("SELECT * FROM boss WHERE email = ? AND password = ?")) {
            preSmt.setString(1, email);
            preSmt.setString(2, password);

            try (ResultSet rs = preSmt.executeQuery()) {
                if (rs.next()) {
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    String passwordBoss = rs.getString("password");

                    // Construct the Employee object
                    boss = new Boss(id, name, passwordBoss);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error db" + ex);
        }

        return boss;
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
