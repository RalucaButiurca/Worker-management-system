package service;

import domeniu.Boss;
import domeniu.Employee;
import repository.BossRepository;
import java.util.List;

import HashUtil.HashUtil;

public class BossService {
    private BossRepository bossRepository;

    public BossService(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
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
    public boolean validateBoss(String email, String password) {
        String hashedPassword = HashUtil.hashPassword(password);
        Boss boss = findBoss(email, hashedPassword);
        if (boss != null) {
//            String hashedPassword = HashUtil.hashPassword(password);
            return boss.getPassword().equals(hashedPassword);
        }
        return false;
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
