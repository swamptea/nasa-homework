package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Post {
    private final String copyright;
    private final Date date;
    private final String explanation;
    private final String hdUrl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

    public Post(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdUrl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public Date getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdUrl;
    }

    public String getMedia_type() {
        return mediaType;
    }

    public String getService_version() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Post{" +
                "copyright='" + copyright + '\'' +
                ", date=" + date +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdUrl + '\'' +
                ", media_type='" + mediaType + '\'' +
                ", service_version='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
