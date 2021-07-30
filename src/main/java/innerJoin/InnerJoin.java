package innerJoin;

import instance.InnerJoinLine;

import java.util.List;

public interface InnerJoin<T> {
    List<InnerJoinLine> innerJoin(T firstTable, T secondTable);
}
