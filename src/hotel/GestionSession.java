package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionSession {
    private static ArrayList<Session>sessions = new ArrayList<Session>();

    public static void addSession(String login, String password) {
        sessions.add(new Session(login,password));
    }
    
    /**
     * @param login le login a tester
     * @param password le mot de passe à tester
     * @return true si la session existe, false sinon.
     */
    public static boolean sessionExist (String login, String password) {
        for (Session s : sessions) {
            if (s.getLogin().equals(login) && s.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean tryToConnect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cette action demande une authentification. entrez votre login : ");
        String login = sc.next();
        System.out.println("entrez votre mot de passe : ");
        String password = sc.next();
        if (sessionExist(login, password)) {
            System.out.println("Utilisateur authentifié.");
//            sc.close();
            return true;
        }
        System.out.println("Utilisateur non reconnu.");
//        sc.close();
        return false;
        
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }
}
