public class Hero extends Unit {
    private String attribute;
    private String strength;
    private String agility;
    private String intelligence;
    private int moveSpeed;

    public Hero(String unit, double armor, String attackDamage, double bat, String attackType, int attackRange, int visionDay, int visionNight,
                String attribute, String strength, String agility, String intelligence, int moveSpeed) {
        super(unit, armor, attackDamage, bat, attackType, attackRange, visionDay, visionNight);
        this.attribute = attribute;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.moveSpeed = moveSpeed;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    @Override
    public String toString() {
        return String.format(
                "Герой: %s | Броня: %.2f | Урон: %s | BAT: %.2f | Тип атаки: %s | Дальность атаки: %d | Дневной обзор: %d | Ночной обзор: %d | Атрибут: %s | Сила: %s | Ловкость: %s | Интеллект: %s | Скорость передвижения: %d",
                getUnit(), getArmor(), getAttackDamage(), getBat(), getAttackType(), getAttackRange(), getVisionDay(), getVisionNight(),
                attribute, strength, agility, intelligence, moveSpeed
        );
    }
}