package ru.job4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {

    public static void main(String[] args)  {
        try {
            RandomAccessFile randomAccess = new RandomAccessFile("data/random.txt", "rw");
            randomAccess.writeInt(100);
            randomAccess.writeChar('A');
            randomAccess.writeBoolean(true);
            randomAccess.seek(4);
            randomAccess.writeChar('B');
            randomAccess.seek(4);
            System.out.println(randomAccess.readChar());
            randomAccess.seek(randomAccess.length());
            System.out.println("Положение указателя после boolean: " + randomAccess.getFilePointer());
            randomAccess.writeDouble(3.5);
            randomAccess.seek(7);
            System.out.println(randomAccess.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
