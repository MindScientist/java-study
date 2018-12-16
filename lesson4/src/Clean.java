import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.io.IOException;
import java.net.URL;

public class Clean {
    public static void main(String[] args) throws IOException, XPatherException {
        HtmlCleaner cleaner = new HtmlCleaner();
        final String siteUrl = "https://habr.com/top/";

        TagNode node = cleaner.clean(new URL(siteUrl));

        Object[] obj = node.evaluateXPath("//a[@class='post__title_link']");
        for (Object o : obj) {
            System.out.println(((TagNode)o).getText());
        }
    }
}
