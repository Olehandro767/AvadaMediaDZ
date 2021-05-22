package ua.AvadaMedia.adminREST.RequestBody;

public class CinemaRequestBody {

    private String name;
    private String description;
    private String aboutCinema;
    private String conditions;
    private long seoBlockId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAboutCinema() {
        return aboutCinema;
    }

    public String getConditions() {
        return conditions;
    }

    public long getSeoBlockId() {
        return seoBlockId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAboutCinema(String aboutCinema) {
        this.aboutCinema = aboutCinema;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public void setSeoBlockId(long seoBlockId) {
        this.seoBlockId = seoBlockId;
    }

}