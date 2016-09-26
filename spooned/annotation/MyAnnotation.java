package annotation;


public @interface MyAnnotation {
    java.lang.String myAttribute() default "defaultValue";
    
}

