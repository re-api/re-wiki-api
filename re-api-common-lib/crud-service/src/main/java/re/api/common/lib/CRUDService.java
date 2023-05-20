package re.api.common.lib;

import java.util.List;
import java.util.UUID;

public interface CRUDService<T> {

    List<T> findByName(final String name);

    List<T> listAll();
    T getById(UUID uuid);

    boolean save(T t);

    boolean deleteById(UUID uuid);
}
