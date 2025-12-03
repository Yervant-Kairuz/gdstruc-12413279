import java.util.Objects;

public class Player {
    private int playerID;
    private String userName;
    private int level;

    public Player(int id, String name, int level) {
        this.playerID = id;
        this.userName = name;
        this.level = level;
    }

    public int getId() {
        return playerID;
    }

    public void setId(int id) {
        this.playerID = id;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + playerID +
                ", name='" + userName + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerID == player.playerID && level == player.level && Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID, userName, level);
    }
}
