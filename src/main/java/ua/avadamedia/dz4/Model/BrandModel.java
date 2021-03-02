package ua.avadamedia.dz4.Model;

import java.util.UUID;

public class BrandModel {

    private UUID id;
    private String brandName;
    private int brandLifetime;

//    private void init(String brandName, int brandLifetime) {
//        this.brandName = brandName;
//        this.brandLifetime = brandLifetime;
//    }

//    public BrandModel(String brandName, int brandLifetime) {
//        init(brandName, brandLifetime);
//    }

    public BrandModel(UUID id, String brandName, int brandLifetime) {
        this.id = id;
        this.brandName = brandName;
        this.brandLifetime = brandLifetime;
//        init(brandName, brandLifetime);
    }

    public UUID getId() {
        return id;
    }

    public int getBrandLifetime() {
        return brandLifetime;
    }

    public String getBrandName() {
        return brandName;
    }

}