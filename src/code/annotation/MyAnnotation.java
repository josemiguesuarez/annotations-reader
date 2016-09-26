package code.annotation;

public @interface MyAnnotation {
	String myAttribute() default "defaultValue";
	String mandatory() default "false";

}
