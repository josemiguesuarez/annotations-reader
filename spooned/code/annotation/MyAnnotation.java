

package code.annotation;


public @interface MyAnnotation {
    java.lang.String myAttribute() default "defaultValue";

    java.lang.String mandatory() default "false";
}

