package ua.AvadaMedia.adminREST.RequestBody;

public class SEOBlockRequestBody {

    private String seoURL;
    private String seoTitle;
    private String seoKeyword;
    private String seoDescription;

    public String getSeoURL() {
        return seoURL;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoURL(String seoURL) {
        this.seoURL = seoURL;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

}