package ru.sbertech.android.codegen;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("ru.sbertech.android.codegen.CountryCodegenFactory")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

        ClassName stringClass = ClassName.get(String.class);

        ClassName mapClass = ClassName.get(Map.class);
        TypeName mapOfStringMarker = ParameterizedTypeName.get(mapClass, stringClass, TypeName.get(Country.class));

        ClassName hashMapClass = ClassName.get(HashMap.class);
        TypeName hashMapOfStringMarker = ParameterizedTypeName.get(hashMapClass, stringClass, TypeName.get(Country.class));

        String putEntityString = "";
        for (Element element : roundEnvironment.getElementsAnnotatedWith(CountryCodegenFactory.class)) {
            putEntityString = putEntityString + "put(\"" + element.getAnnotation(CountryCodegenFactory.class).value()
                    + "\", new " + element.toString() + "()); \n        ";
        }

        FieldSpec android = FieldSpec.builder(mapOfStringMarker, "__factoryMap")
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .initializer("$T.unmodifiableMap(new $T()  {\n    {\n        $L \n    } \n})",
                        Collections.class,
                        hashMapOfStringMarker, putEntityString)
                .build();

        MethodSpec create = MethodSpec.methodBuilder("getCountry")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.get(Country.class))
                .addParameter(String.class, "name")
                .addStatement("return __factoryMap.get(name)")
                .build();


        TypeSpec autogenerateClass = TypeSpec.classBuilder("Factory$$$Autogenerate")
                .addSuperinterface(CountryFactory.class)
                .addModifiers(Modifier.PUBLIC)
                .addField(android)
                .addMethod(create)
                .build();


        JavaFile javaFile = JavaFile.builder("ru.sbertech.android.codegen.myapplication.loggen",
                autogenerateClass)
                .build();

        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}