public class Unit {
    private String unit;
    private double armor;
    private String attackDamage;
    private double bat;
    private String attackType;
    private int attackRange;
    private int visionDay;
    private int visionNight;

    public Unit(String unit, double armor, String attackDamage, double bat, String attackType, int attackRange, int visionDay, int visionNight) {
        this.unit = unit;
        this.armor = armor;
        this.attackDamage = attackDamage;
        this.bat = bat;
        this.attackType = attackType;
        this.attackRange = attackRange;
        this.visionDay = visionDay;
        this.visionNight = visionNight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public String getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(String attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getBat() {
        return bat;
    }

    public void setBat(float bat) {
        this.bat = bat;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getVisionDay() {
        return visionDay;
    }

    public void setVisionDay(int visionDay) {
        this.visionDay = visionDay;
    }

    public int getVisionNight() {
        return visionNight;
    }

    public void setVisionNight(int visionNight) {
        this.visionNight = visionNight;
    }

    @Override
    public String toString() {
        return String.format("Юнит: %s | Броня: %.2f | Урон: %s | BAT: %.2f | Тип атаки: %s | Дальность атаки: %d | Дневной обзор: %d | Ночной обзор: %d",
                this.unit, this.armor, this.attackDamage, this.bat, this.attackType, this.attackRange, this.visionDay, this.visionNight);
    }
}
