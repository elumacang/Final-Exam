package fourthexamlumacang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lumacang
 */
public class GraphClass {
    private Map<String, Set<String>> mapFriends;

    public GraphClass () {
        mapFriends = new HashMap<>();
    }

    public void addUserName (String user) {
        mapFriends.putIfAbsent(user, new HashSet<>());
    }

    public void addFriendName(String user1, String user2) {
        mapFriends.putIfAbsent(user1, new HashSet<>());
        mapFriends.putIfAbsent(user2, new HashSet<>());
        mapFriends.get(user1).add(user2);
        mapFriends.get(user2).add(user1);
    }

    public void displayAllFriends() {
        for (var entry : mapFriends.entrySet()) {
            System.out.print(entry.getKey() + "'s friends: ");
            for (String friend : entry.getValue()) {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
    }

    public Set<String> getRecommendedFriendsNames(String user) {
        Set<String> reco = new HashSet<>();
        Set<String> userFriends = mapFriends.getOrDefault(user, new HashSet<>());

        for (String friend : userFriends) {
            for (String friendsFriend : mapFriends.getOrDefault(friend, new HashSet<>())) {
                if (!userFriends.contains(friendsFriend) && !friendsFriend.equals(user)) {
                    reco.add(friendsFriend);
                }
            }
        }
        return reco;
    }
}

