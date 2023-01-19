package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionSession {
    ArrayList<Session>sessions = new ArrayList<Session>();

    public void addSession(String login, String password) {
        sessions.add(new Session(login,password));
    }
    
    /**
     * @param login le login a tester
     * @param password le mot de passe à tester
     * @return true si la session existe, false sinon.
     */
    public boolean sessionExist (String login, String password) {
        for (Session s : sessions) {
            if (s.getLogin().equals(login) && s.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean tryToConnect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cette action demande une authentification. entrez votre login : ");
        String login = sc.next();
        System.out.println("entrez votre mot de passe : ");
        String password = sc.next();
        if (sessionExist(login, password)) {
            System.out.println("Utilisateur authentifié.");
            return true;
        }
        System.out.println("Utilisateur non reconnu.");
        return false;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }
}
