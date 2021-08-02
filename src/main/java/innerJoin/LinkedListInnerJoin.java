package innerJoin;

import instance.InnerJoinLine;
import instance.Line;

import java.util.*;

public class LinkedListInnerJoin implements InnerJoin<LinkedList<Line>> {
    @Override
    public List<InnerJoinLine> innerJoin(LinkedList<Line> firstTable, LinkedList<Line> secondTable) {
        List<InnerJoinLine> result = new ArrayList<>();

        ListIterator<Line> firstIter = firstTable.listIterator();
        ListIterator<Line> secondIter = secondTable.listIterator();
        Line firstLine;
        Line secondLine;
        int lastId;

        while (firstIter.hasNext()) {
            firstLine = firstIter.next();
            while (secondIter.hasNext()) {
                secondLine = secondIter.next();
                if (firstLine.getId() < secondLine.getId()) {
                    secondIter.previous();
                    break;
                } else if (firstLine.getId().equals(secondLine.getId())) {
                    lastId = secondLine.getId();
                    result.add(new InnerJoinLine(firstLine, secondLine));
                    if (firstIter.hasNext()) {
                        if (firstIter.next().getId().equals(lastId)) {
                            if (secondIter.hasNext()) {
                                if (secondIter.next().getId().equals(lastId)) {
                                    secondIter.previous();
                                    firstIter.previous();
                                    continue;
                                } else {
                                    secondIter.previous();
                                }
                            }

                            firstIter.previous();

                            while (secondIter.previous().getId().equals(lastId) && secondIter.hasPrevious()) {
                                secondIter.next();
                                if (secondIter.hasPrevious()) {
                                    secondIter.previous();
                                } else {
                                    break;
                                }
                            }

                            break;
                        } else {
                            firstIter.previous();
                        }
                    } else {
                        if (secondIter.hasNext()) {
                            if (secondIter.next().getId().equals(lastId)) {
                                secondIter.previous();
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
}
