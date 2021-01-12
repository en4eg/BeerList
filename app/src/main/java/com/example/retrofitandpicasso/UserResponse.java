package com.example.retrofitandpicasso;

public class UserResponse {

    private int id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;




    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTagline() {
        return tagline;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return image_url;
        
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagline='" + tagline + '\'' +
                ", first_brewed='" + first_brewed + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }

}
