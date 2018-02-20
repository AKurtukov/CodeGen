package ru.sbertech.android.codegen.myapplication;

import android.content.Context;
import android.util.Log;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ru.sbertech.android.codegen.myapplication.entity.EntityForReflection;

public class FactoryReflection {

    Reflections reflections = new Reflections(ClasspathHelper.contextClassLoader());
    Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(EntityForReflection.class);

    FactoryReflection(Context context){
        for (Class<?> clazz : annotated) {
//            final Object newInstance = clazz.newInstance();
            try {
                Log.e("Amrel", clazz.newInstance().toString());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        try {
//            DexFile df = new DexFile(context.getPackageCodePath());
//            for (Enumeration<String> iter = df.entries(); iter.hasMoreElements();) {
//                String s = iter.nextElement();
////                Log.e("Amrel", s);
//            }
//
//            List<Class> classes = getClasses(context.getClass().getClassLoader(),"myapplication");
//            Log.e("Amrel", classes.toString());
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static List<Class> getClasses(ClassLoader cl,String pack) throws Exception{

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<Class>();
        URL upackage = cl.getResource(pack);

        DataInputStream dis = new DataInputStream((InputStream) upackage.getContent());
        String line = null;
        while ((line = dis.readLine()) != null) {
            if(line.endsWith(".class")) {
                classes.add(Class.forName(dottedPackage+"."+line.substring(0,line.lastIndexOf('.'))));
            }
        }
        return classes;
    }


}
