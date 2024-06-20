package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    int inputSize = 0;
    int outputSize = 0;

    public T poll() {
        if (outputSize == 0) {
            while (inputSize > 0) {
                output.push(input.pop());
                inputSize--;
                outputSize++;
            }
        }
        if (outputSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        outputSize--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        inputSize++;
    }
}
