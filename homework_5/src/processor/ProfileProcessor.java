package processor;

import annotations.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ProfileProcessor {

    public static List<String> checkRequired(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Required.class)) {
                Object val = field.get(obj);
                if (val == null || val.toString().isEmpty()) {
                    errors.add(field.getName() + " обязательно для заполнения");
                }
            }
        }
        return errors;
    }

    public static List<String> checkLengths(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLen = annotation.value();
                Object val = field.get(obj);
                if (val == null) continue;

                if (val.toString().length() > maxLen) {
                    errors.add(field.getName() + " превышает максимальную длину " +
                            maxLen + " (сейчас: " + val.toString().length() + ")");
                }
            }
        }
        return errors;
    }

    public static void applyDefaults(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(DefaultValue.class)) {
                DefaultValue annotation = field.getAnnotation(DefaultValue.class);
                Object val = field.get(obj);
                if (val == null) {
                    field.set(obj, annotation.value());
                }
            }
        }
    }

    public static void process(Object obj) throws IllegalAccessException {
        System.out.println("===Обработка профиля===");
        System.out.println("Применены значения по умолчанию:");
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(DefaultValue.class)) {
                DefaultValue ann = field.getAnnotation(DefaultValue.class);
                System.out.println(field.getName() + " = \"" + ann.value() + "\"");
            }
        }
        applyDefaults(obj);
        List<String> errors = checkRequired(obj);
        List<String> lengthErrors = checkLengths(obj);
        errors.addAll(lengthErrors);
        System.out.println("Ошибки валидации:");
        if (errors.isEmpty()) {
            System.out.println("Итог: профиль корректен");
        } else {
            for (String err : errors) {
                System.out.println("- " + err);
            }
            System.out.println("Итог: профиль содержит ошибки (" + errors.size() + ")");
        }
    }
}