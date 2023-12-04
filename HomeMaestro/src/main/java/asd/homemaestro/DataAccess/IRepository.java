package asd.homemaestro.DataAccess;

import java.util.List;

public interface IRepository<T> {

    T getElement();
    List<T> getElements();
    T getElementById(String id);
    List<T> getElementsById(String id);
}
