package innerJoin;

import instance.InnerJoinLine;
import instance.Line;

import java.util.ArrayList;
import java.util.List;

public class ArrayListInnerJoin implements InnerJoin<ArrayList<Line>> {
    @Override
    public List<InnerJoinLine> innerJoin(ArrayList<Line> firstTable, ArrayList<Line> secondTable) {
        List<InnerJoinLine> result = new ArrayList<>();

        firstTable.forEach(line -> secondTable.forEach(secondLine -> {
            if (line.getId().equals(secondLine.getId())) {
                result.add(new InnerJoinLine(line, secondLine));
            }
        }));

        return result;
    }
}
