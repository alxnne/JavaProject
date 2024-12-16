import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeroParse {
    private static Document documentHero;
    private static Document documentForAttributes;
    public HeroParse() {
        getWebDocumentHero();
        getWebDocumentForAttributes();
    }

    private void getWebDocumentHero() {
        try {
            documentHero = Jsoup.connect("https://liquipedia.net/dota2/Table_of_hero_attributes").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void getWebDocumentForAttributes() {
        try {
            documentForAttributes = Jsoup.connect("https://dota2.ru/heroes/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Hero> heroParse() {
        Elements heroesTable = documentForAttributes.select("div.base-hero__block");
        String [] strengthHeroes = heroesTable.get(0).text().split(" ");
        String [] agilityhHeroes = heroesTable.get(1).text().split(" ");
        String [] intelligenceHeroes = heroesTable.get(2).text().split(" ");
        String [] universalHeroes = heroesTable.get(3).text().split(" ");
        String[][] allHeroAttributes = {strengthHeroes, agilityhHeroes, intelligenceHeroes, universalHeroes};
        Element allHeroes = documentHero.select("table").first();
        Elements rows = allHeroes.select("tbody tr");
        List<Hero> heroes = new ArrayList<>();
        for (Element row : rows) {
            Elements cells = row.select("td");
            if (cells.size() == 29) {
                String unit = cells.get(0).text();
                int foundHero = -1;
                String attribute = "Интеллект";
                for (int i = 0; i < allHeroAttributes.length; i++) {
                    for (int j = 0; j < allHeroAttributes[i].length; j++) {
                        if (unit.equals("Shadow Fiend")){
                            attribute = "Ловкость";
                            break;
                        }
                        if (unit.equals("Spirit Breaker")){
                            attribute = "Сила";
                            break;
                        }
                        if (allHeroAttributes[i][j].equals(unit.split(" ")[0])) {
                            attribute = allHeroAttributes[i][0];
                            break;
                        }
                    }
                }
                String strength = cells.get(2).text() +'-'+ cells.get(3).text();
                String agility = cells.get(5).text() +'-'+ cells.get(6).text();
                String intelligence = cells.get(8).text() +'-'+ cells.get(9).text();
                int moveSpeed = Integer.parseInt(cells.get(14).text());
                String attackDamage = cells.get(16).text() +'-'+ cells.get(17).text();
                int attackRange = Integer.parseInt(cells.get(18).text());
                int visionDay =  Integer.parseInt(cells.get(23).text());
                int visionNight =  Integer.parseInt(cells.get(24).text());
                double bat = Double.parseDouble(cells.get(20).text());
                double armor = Double.parseDouble(cells.get(15).text());
                String attackType;
                if (attackRange < 330 & !unit.equals("Templar Assassin")){
                    attackType = "Melee";
                }
                else {
                    attackType = "Ranged";
                }
                Hero hero = new Hero(
                        unit,
                        armor,
                        attackDamage,
                        bat,
                        attackType,
                        attackRange,
                        visionDay,
                        visionNight,
                        attribute,
                        strength,
                        agility,
                        intelligence,
                        moveSpeed
                );
                heroes.add(hero);
            }
        }
        return heroes;
    }
}

