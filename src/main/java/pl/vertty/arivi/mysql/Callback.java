// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.mysql;

public interface Callback<T>
{
    T done(final T p0);
    
    void error(final Throwable p0);
}
