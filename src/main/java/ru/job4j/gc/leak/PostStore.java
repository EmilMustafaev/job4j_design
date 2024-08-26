package ru.job4j.gc.leak;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    private static Map<Integer, WeakReference<Post>> posts = new HashMap<>();

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public Post add(Post post) {
        Integer id = atomicInteger.getAndIncrement();
        post.setId(id);
        posts.put(id, new WeakReference<>(post));
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public Map<Integer, WeakReference<Post>> getPosts() {
        return posts;
    }
}
