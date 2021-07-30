package innerJoin;

import instance.InnerJoinLine;
import instance.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapInnerJoin implements InnerJoin<HashMap<Integer, ArrayList<Line>>> {
    @Override
    public List<InnerJoinLine> innerJoin(HashMap<Integer, ArrayList<Line>> firstTable, HashMap<Integer, ArrayList<Line>> secondTable) {
        List<InnerJoinLine> result = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Line>> entry: firstTable.entrySet()) {
            if (secondTable.containsKey(entry.getKey())) {
                for (Line firstLine: entry.getValue()) {
                    for (Line secondLine: secondTable.get(entry.getKey())) {
                        result.add(new InnerJoinLine(firstLine, secondLine));
                    }
                }
            }
        }

        return result;
    }
}
