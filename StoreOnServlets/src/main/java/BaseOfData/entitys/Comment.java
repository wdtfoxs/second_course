package BaseOfData.entitys;

/**
 * Created by nikk on 30.11.2015.
 */
public class Comment {
    private String name;
    private int id;
    private String comment;

    public Comment(String name, int id, String comment) {
        this.name = name;
        this.id = id;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public int getId() {
        return id;
    }
}
