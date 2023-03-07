import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {

        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<String> publicFields = new ArrayList<>();

        for (Field f : fields) {
            int modifiers = f.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                publicFields.add(f.getName());
            }
        }
        return publicFields.toArray(new String[] {});
    }
}