package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.SchemaFactory;
import org.abc.star.jrpc.core.binding.ImplementBinding;

/**
 * Created by whs on 2017/3/30.
 */
public interface AcceptanceFactory extends SchemaFactory {
    public abstract Acceptance create(TransportConfig transportConfig, ImplementBinding implementBinding);
}
