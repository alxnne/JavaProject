import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        UnitDatabase db = new UnitDatabase();
        db.createUnitTable();
        db.createHeroTable();
        db.createCreepTable();

        CreepParse creepParse = new CreepParse();
        var creeps = creepParse.parse();
        for (Creep creep : creeps) {
            System.out.println(creep);
            db.addCreep(creep);
        }

        HeroParse heroParse = new HeroParse();
        var Heroes = HeroParse.heroParse();
        for (Hero hero : Heroes) {
            System.out.println(hero);
            db.addHero(hero);
        }

        HashMap<String, Integer> attributeCount = db.selectAttributeCount();
        ChartHandler chartHandler = new ChartHandler();
        chartHandler.displayAttributePieChart(attributeCount);

    }
}
