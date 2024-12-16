import java.sql.*;
import org.sqlite.JDBC;
import java.util.HashMap;

public class UnitDatabase {
    private static final String CON_STR = "jdbc:sqlite:dota.db";
    private Connection connection;

    {
        DbHandler();
    }

    private void DbHandler() {
        try {
            DriverManager.registerDriver(new JDBC());
            this.connection = DriverManager.getConnection(CON_STR);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUnitTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE units " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " unit_name VARCHAR(255), " +
                    " armor DOUBLE, " +
                    " attack_damage VARCHAR(255), " +
                    " bat DOUBLE, " +
                    " attack_type VARCHAR(255), " +
                    " attack_range INTEGER, " +
                    " vision_day INTEGER, " +
                    " vision_night INTEGER)";
            statement.executeUpdate(sql);
            System.out.println("Table 'units' created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create table 'units'.");
            System.out.println(e.getMessage());
        }
    }

    public void addUnit(Unit unit) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO units(unit_name, armor, attack_damage, bat, attack_type, attack_range, vision_day, vision_night) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, unit.getUnit());
            stmt.setDouble(2, unit.getArmor());
            stmt.setString(3, unit.getAttackDamage());
            stmt.setDouble(4, unit.getBat());
            stmt.setString(5, unit.getAttackType());
            stmt.setInt(6, unit.getAttackRange());
            stmt.setInt(7, unit.getVisionDay());
            stmt.setInt(8, unit.getVisionNight());
            stmt.executeUpdate();
            System.out.println("Unit added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createHeroTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE heroes " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " unit_name VARCHAR(255), " +
                    " armor DOUBLE, " +
                    " attack_damage VARCHAR(255), " +
                    " bat DOUBLE, " +
                    " attack_type VARCHAR(255), " +
                    " attack_range INTEGER, " +
                    " vision_day INTEGER, " +
                    " vision_night INTEGER, " +
                    " attribute VARCHAR(255), " +
                    " strength VARCHAR(255), " +
                    " agility VARCHAR(255), " +
                    " intelligence VARCHAR(255), " +
                    " move_speed INTEGER)";
            statement.executeUpdate(sql);
            System.out.println("Table 'heroes' created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create table 'heroes'.");
            System.out.println(e.getMessage());
        }
    }

    public void addHero(Hero hero) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO heroes(unit_name, armor, attack_damage, bat, attack_type, attack_range, vision_day, vision_night, " +
                            "attribute, strength, agility, intelligence, move_speed) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, hero.getUnit());
            stmt.setDouble(2, hero.getArmor());
            stmt.setString(3, hero.getAttackDamage());
            stmt.setDouble(4, hero.getBat());
            stmt.setString(5, hero.getAttackType());
            stmt.setInt(6, hero.getAttackRange());
            stmt.setInt(7, hero.getVisionDay());
            stmt.setInt(8, hero.getVisionNight());
            stmt.setString(9, hero.getAttribute());
            stmt.setString(10, hero.getStrength());
            stmt.setString(11, hero.getAgility());
            stmt.setString(12, hero.getIntelligence());
            stmt.setInt(13, hero.getMoveSpeed());
            stmt.executeUpdate();
            System.out.println("Hero added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Integer> selectAttributeCount() {
        HashMap<String, Integer> attributeCount = new HashMap<>();

        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT attribute, COUNT(*) AS count FROM heroes GROUP BY attribute")) {

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String attribute = resultSet.getString("attribute");
                int count = resultSet.getInt("count");
                attributeCount.put(attribute, count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attributeCount;
    }

    public void createCreepTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE creeps " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " unit_name VARCHAR(255), " +
                    " health INTEGER, " +
                    " armor DOUBLE, " +
                    " attack_damage VARCHAR(255), " +
                    " bat DOUBLE, " +
                    " attack_type VARCHAR(255), " +
                    " attack_range INTEGER, " +
                    " vision_day INTEGER, " +
                    " vision_night INTEGER, " +
                    " gold VARCHAR(255), " +
                    " xp INTEGER)";
            statement.executeUpdate(sql);
            System.out.println("Table 'creeps' created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create table 'creeps'.");
            System.out.println(e.getMessage());
        }
    }

    public void addCreep(Creep creep) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO creeps(unit_name, health, armor, attack_damage, bat, attack_type, attack_range, vision_day, vision_night, gold, xp) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, creep.getUnit());
            stmt.setInt(2, creep.getHealth());
            stmt.setDouble(3, creep.getArmor());
            stmt.setString(4, creep.getAttackDamage());
            stmt.setDouble(5, creep.getBat());
            stmt.setString(6, creep.getAttackType());
            stmt.setInt(7, creep.getAttackRange());
            stmt.setInt(8, creep.getVisionDay());
            stmt.setInt(9, creep.getVisionNight());
            stmt.setString(10, creep.getGold());
            stmt.setInt(11, creep.getXp());
            stmt.executeUpdate();
            System.out.println("Creep added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}