package LYC.注释;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(ElementType.ANNOTATION_TYPE)
public @interface PepoleName {
    String value()default "zhangsan";
}
