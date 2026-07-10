import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecretMessageDecoder {

    private static class Cell {
        int x, y;
        char ch;
        Cell(int x, char ch, int y) {
            this.x = x;
            this.ch = ch;
            this.y = y;
        }
    }

    public static void printSecretMessage(String docUrl) {
        try {
            String html = fetchHtml(docUrl);
            List<Cell> cells = parseTable(html);
            renderGrid(cells);
        } catch (Exception e) {
            throw new RuntimeException("Failed to decode secret message", e);
        }
    }

    private static String fetchHtml(String docUrl) throws Exception {
        URL url = new URL(docUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString();
    }

    private static List<Cell> parseTable(String html) {
        List<Cell> cells = new ArrayList<>();


        Pattern rowPattern = Pattern.compile("<tr>(.*?)</tr>", Pattern.DOTALL);
        Pattern cellPattern = Pattern.compile("<td[^>]*>(.*?)</td>", Pattern.DOTALL);
        Pattern tagStrip = Pattern.compile("<[^>]+>");

        Matcher rowMatcher = rowPattern.matcher(html);
        while (rowMatcher.find()) {
            List<String> tds = new ArrayList<>();
            Matcher cellMatcher = cellPattern.matcher(rowMatcher.group(1));
            while (cellMatcher.find()) {
                String raw = cellMatcher.group(1);
                String clean = tagStrip.matcher(raw).replaceAll("").trim();
                clean = clean.replace("&nbsp;", " ");
                tds.add(clean);
            }

            if (tds.size() == 3) {
                String xStr = tds.get(0);
                String chStr = tds.get(1);
                String yStr = tds.get(2);

                if (!xStr.matches("\\d+") || !yStr.matches("\\d+") || chStr.isEmpty()) {
                    continue;
                }

                int x = Integer.parseInt(xStr);
                int y = Integer.parseInt(yStr);
                char ch = chStr.charAt(0);
                cells.add(new Cell(x, ch, y));
            }
        }
        return cells;
    }

    private static void renderGrid(List<Cell> cells) {
        if (cells.isEmpty()) {
            System.out.println("(no data found)");
            return;
        }

        int maxX = 0;
        int maxY = 0;
        for (Cell c : cells) {
            if (c.x > maxX) maxX = c.x;
            if (c.y > maxY) maxY = c.y;
        }

        char[][] grid = new char[maxY + 1][maxX + 1];
        for (char[] row : grid) {
            java.util.Arrays.fill(row, ' ');
        }

        for (Cell c : cells) {
            grid[c.y][c.x] = c.ch;
        }

        StringBuilder out = new StringBuilder();
        for (int y = maxY; y >= 0; y--) {
            out.append(new String(grid[y])).append('\n');
        }
        System.out.print(out);
    }

    public static void main(String[] args) {
        String url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
        printSecretMessage(url);
    }
}