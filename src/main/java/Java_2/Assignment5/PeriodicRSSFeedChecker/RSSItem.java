package Java_2.Assignment5.PeriodicRSSFeedChecker;

import java.util.Objects;

/**
 * RSSItem represents an item in an RSS feed.
 * It contains the title, link, and publication date of the RSS feed item.
 */
public class RSSItem {
    private String title;
    private String link;
    private String pubDate;

    /**
     * Constructs an RSSItem with the specified title, link, and publication date.
     *
     * @param title   The title of the RSS feed item.
     * @param link    The link to the RSS feed item.
     * @param pubDate The publication date of the RSS feed item.
     */
    public RSSItem(String title, String link, String pubDate) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
    }

    /**
     * Returns the title of the RSS feed item.
     *
     * @return The title of the RSS feed item.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the link to the RSS feed item.
     *
     * @return The link to the RSS feed item.
     */
    public String getLink() {
        return link;
    }

    /**
     * Returns the publication date of the RSS feed item.
     *
     * @return The publication date of the RSS feed item.
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * This method overrides the default equals method to provide custom equality logic for RSSItem objects.
     * Two RSSItem objects are considered equal if their titles, links, and publication dates are the same.
     *
     * @param newItem the reference object with which to compare.
     * @return {@code true} if this object is the same as the object argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object newItem) {
        if (this == newItem) return true;
        if (newItem == null || getClass() != newItem.getClass()) return false;
        RSSItem rssItem = (RSSItem) newItem;
        return Objects.equals(title, rssItem.title) &&
                Objects.equals(link, rssItem.link) &&
                Objects.equals(pubDate, rssItem.pubDate);
    }
}


