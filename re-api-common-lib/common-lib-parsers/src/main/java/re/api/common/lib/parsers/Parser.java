package re.api.common.lib.parsers;

public interface Parser<T> {

    T parse(String string);
}
