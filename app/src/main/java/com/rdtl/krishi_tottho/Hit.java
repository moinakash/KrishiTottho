package com.rdtl.krishi_tottho;
/*import com.google.gson.annotations.Expose;*/
import com.google.gson.annotations.SerializedName;


public class Hit {





   /* private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;
    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }*/



    private Integer id;
    @SerializedName("title")

    private String title;
    @SerializedName("description")

    private String description;
    @SerializedName("image")

    private String image;
    @SerializedName("created_at")

    private String createdAt;
    @SerializedName("updated_at")

    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}