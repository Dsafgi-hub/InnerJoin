package instance;

public class Line {
    private Integer id;
    private String field;

    public Line(Integer id, String field) {
        this.id = id;
        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String toString() {
        return id.toString() + ", " + field;
    }
}
