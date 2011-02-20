import com.sun.btrace.aggregation.*;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@BTrace
public class traceobjects {
    private static Map<String, AtomicInteger> histo = newHashMap();
    private static Aggregation count = Aggregations.newAggregation(AggregationFunction.COUNT);

    @TLS
    private static int tracing = 0;

    @OnMethod(clazz="org.eclipse.core.internal.databinding.property.value.MapSimpleValueObservableMap$1", method="updateKnownValues")
    public static void onEnterUpdateKnownValues() {
        tracing += 1;
    }

    @OnMethod(clazz="+java.lang.Object", method="<init>")
    public static void onAnyMethod(@Self Object obj) {
        println("Object <init>");
        if( tracing > 0 ) {
            String className = name(classOf(obj));
            AtomicInteger ai = get(histo, className);
            if( ai == null ) {
                ai = newAtomicInteger(1);
                put(histo, className, ai);
            } else {
                incrementAndGet(ai);
            }
        }
    }

    @OnMethod(clazz="org.eclipse.core.internal.databinding.property.value.MapSimpleValueObservableMap$1", method="updateKnownValues", location=@Location(Kind.RETURN))
    public static void onReturnUpdateKnownValues() {
        tracing -= 1;
    }

    @OnEvent
    public static void print() {
        println("Received event.");
        if( size(histo) != 0 ) {
            printNumberMap("Allocation Histogram", histo);
        }
    }
}