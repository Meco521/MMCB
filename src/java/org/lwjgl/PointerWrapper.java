package org.lwjgl;

import org.lwjgl.system.Pointer;

public interface PointerWrapper extends Pointer {

    long getPointer();

    @Override
    default long address() {
        return getPointer();
    }
}
