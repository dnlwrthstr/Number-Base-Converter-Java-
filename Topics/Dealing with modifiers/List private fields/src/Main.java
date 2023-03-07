import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public List<String> getPrivateFields(Object object) {
        Class clazz = object.getClass();
        Field[] arrFields = clazz.getDeclaredFields();
        List<String> privateMethodNames = new ArrayList<>();
        Stream<Field> fields = Arrays.stream(arrFields);
        fields.forEach(field -> {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateMethodNames.add(field.getName());
            }
        });
        Collections.sort(privateMethodNames);
        return privateMethodNames;
    }
}