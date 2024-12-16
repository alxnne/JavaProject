import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreepParse {
    private Document document;

    public CreepParse() {
        getWeb();
    }

    private void getWeb() {
        try {
            document = Jsoup.connect("https://liquipedia.net/dota2/Lane_Creeps").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Creep> parse() {
        Element table = document.select("table.wikitable.sortable").first();
        Elements rows = table.select("tbody tr");
        List<Creep> creeps = new ArrayList<>();
        for (Element row : rows) {
            Elements cells = row.select("td");
            if (cells.size() == 10) {
                String unit = cells.get(0).text();
                int health = Integer.parseInt(cells.get(2).text());
                int armor = Integer.parseInt(cells.get(3).text());
                String attackDamage = cells.get(4).text().split(" ")[0];
                int bat = Integer.parseInt(cells.get(5).text());
                int attackRange = Integer.parseInt(cells.get(6).text());
                String attackType;
                if (attackRange == 100) {
                    attackType = "Melee";
                } else {
                    attackType = "Ranged";
                }
                int visionDay = Integer.parseInt(cells.get(7).text().split(" ")[0]);
                int visionNight = Integer.parseInt(cells.get(7).text().split(" ")[1]);
                String gold = cells.get(8).text().split(" ")[0];
                int xp = Integer.parseInt(cells.get(9).text());
                Creep creep = new Creep(unit, health, armor, attackDamage, bat, attackType, attackRange, visionDay, visionNight, gold, xp);
                creeps.add(creep);
            }
        }
        return creeps;
    }
}