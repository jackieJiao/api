package com.rongshu.api.test.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for(Method m:cl.getDeclaredMethods()){
            UseCase uc=m.getAnnotation(UseCase.class);
            if(uc!=null){
                System.out.println("Found UseCase Annotation:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        for(int i:useCases){
            System.out.println("Missing!!!"+i);
        }


    }


    public static void main(String[] args) {
        List<Integer> useCases=new ArrayList<>();
        Collections.addAll(useCases,47,48);
        trackUseCases(useCases,PasswordUtils.class);
    }
}
