package learn.basic.generics.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlexibleGenericStack<T> {
    private List<T> entries;
    private final int userDefinedCapacity;

    public int getUserDefinedCapacity() {
        return userDefinedCapacity;
    }

    public FlexibleGenericStack(int userDefinedCapacity) {
        entries = new ArrayList<>();
        this.userDefinedCapacity = userDefinedCapacity;
    }

    public boolean isNotFull() {
        return isSpaceAvailable(1);
    }

    public boolean isNotEmpty() {
        return entries.size() > 0 ? true : false;
    }

    public void push(T t) {
        Objects.requireNonNull(t, "Can't make null Entries to the Stack");
        if (!isNotFull()) {
            throw new IllegalStateException("Stack is full already!");
        }
        pushIntoStack(t);
    }

    public T pop() {
        if (!isNotEmpty()) {
            throw new IllegalStateException("Stack is Empty!");
        }
        return popFromStack();
    }

    public void pushAll(List<? extends T> inputEntries) {
        Objects.requireNonNull(inputEntries, "Can't make null Entries to the Stack");
        if (inputEntries.isEmpty()) {
            return;
        }
        if (!isSpaceAvailable(inputEntries.size())) {
            throw new IllegalStateException(
                    String.format("Stack only has space for %d more entries!",
                            userDefinedCapacity - entries.size()));
        }
        entries.addAll(inputEntries);
    }

    public List<? super T> popAll(List<? super T> poppedEntries) {
        while (isNotEmpty()) {
            poppedEntries.add(popFromStack());
        }
        return poppedEntries;
    }

    @Override
    public String toString() {
        return "FlexibleGenericStack{" +
                "entries=" + entries +
                ", userDefinedCapacity=" + userDefinedCapacity +
                '}';
    }

    private boolean isSpaceAvailable(int size) {
        return this.entries.size() + size <= userDefinedCapacity ? true : false;
    }

    private T popFromStack() {
        return entries.remove(entries.size() - 1);
    }

    private void pushIntoStack(T t) {
        entries.add(t);
    }
}
