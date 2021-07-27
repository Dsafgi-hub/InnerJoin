package instance;

public class Line {
    private Integer id;
    private String field;
    private String joinField;

    public Line(Integer id, String field) {
        this.id = id;
        this.field = field;
    }

    public Line(Integer id, String field, String resultField) {
        this.id = id;
        this.field = field;
        this.joinField = resultField;
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

    public String getJoinField() {
        return joinField;
    }

    public void setJoinField(String joinField) {
        this.joinField = joinField;
    }
}
