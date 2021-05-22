package ua.AvadaMedia.adminREST.RequestBody;

public class MovieRequestBody {

    private String name;
    private String description;
//    private String link;
//    private boolean twoD;
//    private boolean threeD;
//    private boolean imax;
    private long seoBlockId = -1;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//    public String getLink() {
//        return link;
//    }

//    public boolean isTwoD() {
//        return twoD;
//    }

//    public boolean isThreeD() {
//        return threeD;
//    }

//    public boolean isImax() {
//        return imax;
//    }

    public long getSeoBlockId() {
        return seoBlockId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setLink(String link) {
//        this.link = link;
//    }

//    public void setTwoD(boolean twoD) {
//        this.twoD = twoD;
//    }

//    public void setThreeD(boolean threeD) {
//        this.threeD = threeD;
//    }

//    public void setImax(boolean imax) {
//        this.imax = imax;
//    }

    public void setSeoBlockId(long seoBlockId) {
        this.seoBlockId = seoBlockId;
    }

}