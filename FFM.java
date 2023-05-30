import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.SegmentAllocator.implicitAllocator;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

public class FFM {
    public static void main(String[] args) throws Throwable {
        SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();
        MethodHandle strlen = Linker.nativeLinker().downcallHandle(
                stdlib.lookup("strlen").orElseThrow(),
                FunctionDescriptor.of(JAVA_LONG, ADDRESS));
        MemorySegment str = implicitAllocator().allocateUtf8String("Happy Coding!");
        long len = (long) strlen.invoke(str);
        System.out.println(len);
    }
}
