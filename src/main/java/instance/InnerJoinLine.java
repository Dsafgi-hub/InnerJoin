package instance;

public class InnerJoinLine {
    private Line firstLine;
    private Line secondLine;

    public InnerJoinLine(Line firstLine, Line secondLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    public Line getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(Line firstLine) {
        this.firstLine = firstLine;
    }

    public Line getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(Line secondLine) {
        this.secondLine = secondLine;
    }

    @Override
    public String toString() {
        return String.format("%-7d %15s %15s\n", firstLine.getId(),firstLine.getField(),secondLine.getField());
    }
}
