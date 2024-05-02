package service;

import domeniu.Boss;
import domeniu.Employee;
import repository.BossRepository;
import java.util.List;

public class BossService {
    private BossRepository bossRepository;

    public BossService() {
        this.bossRepository = new BossRepository();
    }

    public void addBoss(Boss Boss) {
        bossRepository.addBoss(Boss);
    }

    public Boss findBossById(int id) {
        return bossRepository.findBossById(id);
    }

    public Boss findBoss(String email, String password) {
        return bossRepository.findBoss(email, password);
    }

    public void updateBoss(Boss Boss) {
        bossRepository.updateBoss(Boss);
    }

    public void deleteBoss(Boss Boss) {
        bossRepository.deleteBoss(Boss);
    }

    public List<Boss> getAllBosses() {
        return bossRepository.getBosses();
    }
}
