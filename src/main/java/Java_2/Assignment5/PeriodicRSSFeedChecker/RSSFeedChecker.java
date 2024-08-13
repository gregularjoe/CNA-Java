package Java_2.Assignment5.PeriodicRSSFeedChecker;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * RSSFeedChecker is a Runnable class that periodically checks an RSS feed for updates.
 * It parses the feed and prints the latest posts to the console.
 */
public class RSSFeedChecker implements Runnable {
    private final String feedUrl;
    private final List<RSSItem> previousItems;
    private RSSItem newItem;

    /**
     * Constructor for RSSFeedChecker.
     *
     * @param feedUrl The URL of the RSS feed to monitor.
     */
    public RSSFeedChecker(String feedUrl) {
        this.feedUrl = feedUrl;
        this.previousItems = new ArrayList<>();
        RSSItem firstData = new RSSItem("sampleTitle","sampleLink","samplePubDate");
        this.previousItems.add(firstData);
    }

    /**
     * Implements the run method from the Runnable interface.
     * This method checks the RSS feed for updates and prints the latest items if there are any updates.
     */
    @Override
    public void run() {
        try {
            URL url = new URL(feedUrl);

            /*
             * Class DocumentBuilderFactory. Defines a factory API that enables applications
             * to obtain a parser that produces DOM object trees from XML documents. Allows the
             * user to retrieve specific attributes on the underlying implementation.
             */
            // XML Document building
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            // Parsing the RSS feed items
            NodeList itemList = doc.getElementsByTagName("item");
            List<RSSItem> items = new ArrayList<>();

            /*
             * Loops over itemsList and adds title, link and pubData to items array.
             */
            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;
                    String title = itemElement.getElementsByTagName("title").item(0).getTextContent();
                    String link = itemElement.getElementsByTagName("link").item(0).getTextContent();
                    String pubDate = itemElement.getElementsByTagName("pubDate").item(0).getTextContent();

                    items.add(new RSSItem(title, link, pubDate));

                }

            }
            newItem = items.get(2);

            /*
             * If the newItem can be found in the previousItems array a message is sent to console
             * that there are no new links to be found in the RSS Feed.
             *
             * If the newItem can NOT be found in the previousItems array the title, link, and pubDate of the
             * first 3 objects in
             * items array are printed to the console.
             */
            if (this.previousItems.contains(newItem)) {
                System.out.println("no new links in feed...");

            }else {
                // Printing the latest items
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Latest Feed: " + feedUrl);
                for (int i = 0; i < Math.min(3, items.size()); i++) {

                    RSSItem item = items.get(i);
                    this.previousItems.add(item);

                    System.out.println("Title: " + item.getTitle());
                    System.out.println("Link: " + item.getLink());
                    System.out.println("Published Date: " + item.getPubDate());
                    System.out.println("-----------------------------------------");
                }
                System.out.println("--------------------------------------------------------------------");
            }
            System.out.println("------------------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}