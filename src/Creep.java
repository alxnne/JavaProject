public class Creep extends Unit {
    private int health;
    private String gold;
    private int xp;

    public Creep(String unit, int health, double armor, String attackDamage, double bat, String attackType, int attackRange, int visionDay, int visionNight, String gold, int xp) {
        super(unit, armor, attackDamage, bat, attackType, attackRange, visionDay, visionNight);
        this.health = health;
        this.gold = gold;
        this.xp = xp;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return String.format(
                "Крип: %s | Здоровье: %d | Броня: %.2f | Урон: %s | BAT: %.2f | Тип атаки: %s | Дальность атаки: %d | Дневной обзор: %d | Ночной обзор: %d | Золото: %s | Опыт: %d",
                getUnit(), health, getArmor(), getAttackDamage(), getBat(), getAttackType(), getAttackRange(), getVisionDay(), getVisionNight(),
                gold, xp
        );
    }
}

