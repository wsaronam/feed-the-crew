package Ship
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

annotation class IsFurniture

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@IsFurniture class Furniture {
    fun move() {}
    fun build() {}

    @get:OnGet
    val isBuilt: Boolean = false;

    @set:OnSet
    var needsBuilding: Boolean = true;
}



fun reflections() {
    val classObj = Furniture::class;
    for (method in classObj.declaredMemberFunctions) {
        println(method.name);
    }

    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName);
    }

    val annotated = classObj.findAnnotation<IsFurniture>();
    annotated?.apply {
        println("found annotation");
    }
}