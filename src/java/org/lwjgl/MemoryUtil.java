package org.lwjgl;

import java.nio.*;
import java.nio.charset.*;

public final class MemoryUtil {

    private MemoryUtil() {}

    public static long getAddress0(Buffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress0Safe(Buffer buffer) {
        return buffer == null ? 0 : org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress0(PointerBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress0Safe(PointerBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddress(ByteBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(ByteBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(ShortBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(ShortBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(CharBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(CharBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(IntBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(IntBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(FloatBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(FloatBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(LongBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(LongBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(DoubleBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(DoubleBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddress(PointerBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer);
    }

    public static long getAddress(PointerBuffer buffer, int position) {
        return org.lwjgl.system.MemoryUtil.memAddress(buffer, position);
    }

    public static long getAddressSafe(ByteBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(ByteBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(ShortBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(ShortBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(CharBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(CharBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(IntBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(IntBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(FloatBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(FloatBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(LongBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(LongBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(DoubleBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(DoubleBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static long getAddressSafe(PointerBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memAddressSafe(buffer);
    }

    public static long getAddressSafe(PointerBuffer buffer, int position) {
        return buffer == null ? 0L : getAddress(buffer, position);
    }

    public static ByteBuffer encodeASCII(final CharSequence text) {
        return org.lwjgl.system.MemoryUtil.memASCII(text);
    }

    public static ByteBuffer encodeUTF8(final CharSequence text) {
        return org.lwjgl.system.MemoryUtil.memUTF8(text);
    }

    public static ByteBuffer encodeUTF16(final CharSequence text) {
        return org.lwjgl.system.MemoryUtil.memUTF16(text);
    }

    public static String decodeASCII(final ByteBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memASCII(buffer);
    }

    public static String decodeUTF8(final ByteBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memUTF8(buffer);
    }

    public static String decodeUTF16(final ByteBuffer buffer) {
        return org.lwjgl.system.MemoryUtil.memUTF16(buffer);
    }
}
