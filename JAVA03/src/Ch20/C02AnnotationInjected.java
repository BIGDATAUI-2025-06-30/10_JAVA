package Ch20;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

abstract class C02AnnotationInjected {

    protected C02AnnotationInjected() {
        injectFromClassAnnotation();
    }

    private void injectFromClassAnnotation() {
        Class<?> clazz = this.getClass();
        C02CustomAnnotation ann = clazz.getAnnotation(C02CustomAnnotation.class);
        if (ann == null) return; // 애노테이션 없으면 아무 것도 안 함

        // 핵심 수정: 우리가 찾을 메서드는 CustomAnnotation의 속성 메서드들이므로, 타입을 고정
        Class<?> annType = C02CustomAnnotation.class;

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);

            C02BindFrom bind = f.getAnnotation(C02BindFrom.class);
            String attrName = (bind != null) ? bind.value() : f.getName();

            try {
                Method m = annType.getMethod(attrName); // CustomAnnotation의 속성 메서드
                Object attrVal = m.invoke(ann);

                if (isAssignable(f.getType(), attrVal)) {
                    f.set(this, attrVal);
                }
            } catch (NoSuchMethodException ignore) {
                // 필드명/매핑명이 애노테이션 속성에 없으면 스킵
            } catch (Exception e) {
                throw new RuntimeException("필드 주입 실패: " + f.getName(), e);
            }
        }
    }

    private static boolean isAssignable(Class<?> fieldType, Object val) {
        if (val == null) return !fieldType.isPrimitive();
        Class<?> valType = val.getClass();
        if (fieldType.isAssignableFrom(valType)) return true;
        if (!fieldType.isPrimitive()) return false;

        return (fieldType == int.class && valType == Integer.class)
            || (fieldType == boolean.class && valType == Boolean.class)
            || (fieldType == long.class && valType == Long.class)
            || (fieldType == double.class && valType == Double.class)
            || (fieldType == float.class && valType == Float.class)
            || (fieldType == char.class && valType == Character.class)
            || (fieldType == byte.class && valType == Byte.class)
            || (fieldType == short.class && valType == Short.class);
    }
}