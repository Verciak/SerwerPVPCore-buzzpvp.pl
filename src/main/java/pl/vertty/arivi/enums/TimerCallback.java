package pl.vertty.arivi.enums;

public interface TimerCallback<E>
{
    void success(final E p0);
    
    void error(final E p0);
}
