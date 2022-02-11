
package pl.vertty.arivi.mysql;

public interface Callback<T>
{
    T done(final T p0);
    
    void error(final Throwable p0);
}
