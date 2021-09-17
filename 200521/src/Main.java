import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.UtilKt;

@SuppressWarnings("KotlinInternalInJava")
public class Main {
    public static String renderLambdaToString(FunctionBase lambda) {
        long start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start);
        KFunction kFunction = ReflectLambdaKt.reflect(lambda);
        System.out.println(System.currentTimeMillis() - start);
        if (kFunction != null) {
            System.out.println(System.currentTimeMillis() - start);
            KFunctionImpl impl = UtilKt.asKFunctionImpl(kFunction);
            System.out.println(System.currentTimeMillis() - start);
            if (impl != null) {
                System.out.println(ReflectionObjectRenderer.INSTANCE.renderLambda(impl.getDescriptor()));
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        return null;
    }

    public static void main(String[] args) {
        Lambda lambda = ((Lambda) AWA.INSTANCE.hi());
        renderLambdaToString(lambda);
    }
}