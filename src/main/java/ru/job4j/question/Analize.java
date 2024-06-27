package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> prevMap = new HashMap<>();
        for (User user : previous) {
            prevMap.put(user.getId(), user.getName());
        }

        int added = 0;
        int changed = 0;
        int deleted = previous.size();

        for (User user : current) {
            String prevName = prevMap.get(user.getId());
            if (prevName == null) {
                added++;
            } else {
                deleted--;
                if (!user.getName().equals(prevName)) {
                    changed++;
                }
            }
        }

        return new Info(added, changed, deleted);
    }
}

