package fourthexamlumacang;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Lumacang
 */
public class FourthExamLumacang {
    
    public static void main(String[] args) {
         GraphClass graph = new GraphClass();
        Scanner scn = new Scanner(System.in);

        System.out.println("Social Network System:");
        System.out.println("1. Add User");
        System.out.println("2. Add Friend");
        System.out.println("3. Display All Friends");
        System.out.println("4. Get Recommended Friends");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("\nEnter a choice: ");
            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the user to add: ");
                    String user = scn.nextLine();
                    graph.addUserName(user);
                    System.out.println("User " + user + " is added.");
                    break;

                case 2:
                    System.out.print("Enter the name of the user: ");
                    String user1 = scn.nextLine();
                    System.out.print("Enter the name of the the friend to add: ");
                    String user2 = scn.nextLine();
                    graph.addFriendName(user1, user2);
                    System.out.println("Friendship added between " + user1 + " and " + user2 + ".");
                    break;

                case 3:
                    System.out.println("Displaying all users and their friends:");
                    graph.displayAllFriends();
                    break;

                case 4:
                    System.out.print("Enter the name of the user to get recommendations for: ");
                    String targetUser = scn.nextLine();
                    Set<String> friendsReco = graph.getRecommendedFriendsNames(targetUser);
                    if (friendsReco.isEmpty()) {
                        System.out.println("No recommended friends for " + targetUser + ".");
                    } else {
                        System.out.println("Recommended friends for " + targetUser + ": " + friendsReco);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scn.close();
                    return;

                default:
                    System.out.println("Not in the choices! Kindly try again.");
            }
        }
    }
 }
    

