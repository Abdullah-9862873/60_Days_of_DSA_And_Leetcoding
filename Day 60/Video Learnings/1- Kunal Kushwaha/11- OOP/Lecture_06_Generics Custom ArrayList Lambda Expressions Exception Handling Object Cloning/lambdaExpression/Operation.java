package lambdaExpression;

public interface Operation<T extends Number> {
    T operation(T a, T b);
} 