package sg.edu.np.madpractical2;

public class User {
    private String name;
    private String description;
    private Integer id;
    private Boolean followed;

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Integer getId() {
        return id;
    }
    public Boolean getFollowed() {
        return followed;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public void setId(Integer newId) {
        this.id = newId;
    }
    public void setFollowed(Boolean newFollowed) {
        this.followed = newFollowed;
    }
}
