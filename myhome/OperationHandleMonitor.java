// import all BTrace annotations
import com.sun.btrace.annotations.*;
// import statics from BTraceUtils class
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class OperationHandleMonitor {

    //total OperationHandle left since start monitor
    private static volatile long opCount;

    // @OnMethod annotation tells where to probe.
    @OnMethod(
            clazz="org.apache.hive.service.cli.operation.OperationManager",
            method="addOperation"
    )
    public static void onAddOperation() {
        opCount += 1;
        println("after addOperation,current count");
        println(opCount);
    }

    @OnMethod(
            clazz="org.apache.hive.service.cli.operation.OperationManager",
            method="removeOperation"
    )
    public static void onRemoveOperation() {
        opCount -= 1;
        println("after removeOperation,current count:" );
        println(opCount);
    }
}
